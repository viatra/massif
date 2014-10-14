package hu.bme.mit.massif.oslc.adaptor.resources.factory;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.CellMatlabData;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.communication.datatype.StructMatlabData;
import hu.bme.mit.massif.oslc.adaptor.resources.BlockResource;
import hu.bme.mit.massif.oslc.adaptor.resources.BusCreatorResource;
import hu.bme.mit.massif.oslc.adaptor.resources.BusSelectorResource;
import hu.bme.mit.massif.oslc.adaptor.resources.BusSpecificationResource;
import hu.bme.mit.massif.oslc.adaptor.resources.EnableBlockResource;
import hu.bme.mit.massif.oslc.adaptor.resources.EnableResource;
import hu.bme.mit.massif.oslc.adaptor.resources.FromResource;
import hu.bme.mit.massif.oslc.adaptor.resources.GotoResource;
import hu.bme.mit.massif.oslc.adaptor.resources.InPortBlockResource;
import hu.bme.mit.massif.oslc.adaptor.resources.InPortResource;
import hu.bme.mit.massif.oslc.adaptor.resources.OutPortBlockResource;
import hu.bme.mit.massif.oslc.adaptor.resources.OutPortResource;
import hu.bme.mit.massif.oslc.adaptor.resources.PortBlockResource;
import hu.bme.mit.massif.oslc.adaptor.resources.PortResource;
import hu.bme.mit.massif.oslc.adaptor.resources.SimulinkElementResource;
import hu.bme.mit.massif.oslc.adaptor.resources.SimulinkModelResource;
import hu.bme.mit.massif.oslc.adaptor.resources.SubSystemResource;
import hu.bme.mit.massif.oslc.adaptor.resources.TriggerBlockResource;
import hu.bme.mit.massif.oslc.adaptor.resources.TriggerResource;
import hu.bme.mit.massif.oslc.adaptor.resources.VirtualBlockResource;
import hu.bme.mit.massif.oslc.adaptor.util.IDHelper;
import hu.bme.mit.massif.oslc.adaptor.util.ParallelIterator;
import hu.bme.mit.massif.oslc.adaptor.util.Reference;
import hu.bme.mit.massif.oslc.adaptor.util.Utils;

import java.lang.reflect.Constructor;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.Link;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

@SuppressWarnings({ "unused", "unchecked", "serial" })
public class ResourceFactory {

    private static Map<Class<? extends AbstractResource>, AbstractResourceBuilder> builders;
    private static Map<Type, Class<? extends AbstractResource>>                    typeToResourceMap;
    private static Map<String, Type>                                               simuTypeToResType;
    private static BiMap<String, String>                                           portNameToPortBlockMap;

    private static AbstractResourceBuilder getBuilder(final MatlabCommandFactory commandFactory,
            final IVisitableMatlabData id) {
        final String typeString = MatlabString.getMatlabStringData(commandFactory.getParam().addParam(id)
                .addParam("Type").execute());
        Type type = simuTypeToResType.get(typeString);
        if (type == Type.Block) {
            final String blockTypeString = MatlabString.getMatlabStringData(commandFactory.getParam().addParam(id)
                    .addParam("BlockType").execute());
            if (simuTypeToResType.containsKey(blockTypeString))
                type = simuTypeToResType.get(blockTypeString);
        } else if (type == Type.Port) {
            final String portTypeString = MatlabString.getMatlabStringData(commandFactory.getParam().addParam(id)
                    .addParam("PortType").execute());
            if (simuTypeToResType.containsKey(portTypeString))
                type = simuTypeToResType.get(portTypeString);
        }
        return builders.get(getResourceClass(type));
    }

    private static <T extends AbstractResource> Class<T> getResourceClass(final Type type) {
        return (Class<T>) typeToResourceMap.get(type);
    }

    public static <T extends AbstractResource> T build(final MatlabCommandFactory commandFactory, final String id,
            final String systemId, final Type type) {
        final AbstractResourceBuilder builder = getBuilder(type);
        if (builder == null)
            return null;
        final Class<T> resourceClass = getResourceClass(type);
        final String rid = IDHelper.revertId(id);
        return resourceClass.cast(builder.build(commandFactory, rid, systemId));
    }

    private static AbstractResourceBuilder getBuilder(final Type type) {
        return builders.get(getResourceClass(type));
    }

    private static String handleToId(final MatlabCommandFactory commandFactory, final Double handle) {
        final StringBuilder sb = new StringBuilder();
        final String portType = MatlabString.getMatlabStringData(commandFactory.getParam().addParam(handle)
                .addParam("PortType").execute());
        sb.append(portType);
        if (portType.equals("inport") || portType.equals("outport")) {
            final Double portNumber = Handle.getHandleData(commandFactory.getParam().addParam(handle)
                    .addParam("PortNumber").execute());
            sb.append('.').append(portNumber.intValue());
        }

        return sb.toString();
    }

    private static Double idToHandle(final MatlabCommandFactory commandFactory, final String container, final String id) {
        final Double handle;

        final String portType = getPortType(id);
        final int portNumber = getPortNumber(id);

        final IVisitableMatlabData portHandles = commandFactory.getParam().addParam(container).addParam("PortHandles")
                .execute();

        final Map<String, IVisitableMatlabData> portHandleData = StructMatlabData.getStructMatlabDataData(portHandles);

        final IVisitableMatlabData correctPortHandle = portHandleData.get(portType);

        if (portNumber >= 0)
            handle = Handle.getHandleData(CellMatlabData.getCellMatlabDataData(correctPortHandle).get(portNumber));
        else {
            handle = Handle.getHandleData(correctPortHandle);
        }

        return handle;
    }

    private static String getPortType(final String id) {
        return id.split("\\.")[0];
    }

    /**
     * Gets the port number. Returns -1 if id has no port number;
     *
     * @param id
     * @return
     */
    private static int getPortNumber(final String id) {
        final String[] split = id.split("\\.");
        if (split.length == 1)
            return -1;
        return Integer.parseInt(split[1]);
    }

    public static <T extends AbstractResource> List<T> collect(final MatlabCommandFactory commandFactory,
            final String systemId, final Type type, final int page, final int limit) {
        final AbstractResourceBuilder builder = getBuilder(type);
        if (builder == null)
            return null;
        String systemName = systemId;
        if (!systemId.isEmpty())
            systemName = IDHelper.revertId(systemId.substring(0, systemId.length() - 2));
        return (List<T>) builder.collect(commandFactory, systemName, page, limit);
    }

    public static enum Type {
        SimulinkModel, Block, SubSystem, OutPortBlock, EnableBlock, SimulinkElement, PortBlock, VirtualBlock, InPortBlock, Goto, TriggerBlock, InPort, OutPort, Enable, Trigger, BusSpecification, BusSelector, BusCreator, Port, From
    }

    static {
        simuTypeToResType = new HashMap<String, ResourceFactory.Type>() {
            @Override
            public Type get(final Object key) {
                final Type type = super.get(key);
                if (type == null)
                    return Type.Block;
                return super.get(key);
            }
        };
        simuTypeToResType.put("block_diagram", Type.SimulinkModel);
        simuTypeToResType.put("Block", Type.Block);
        simuTypeToResType.put("SubSystem", Type.SubSystem);
        simuTypeToResType.put("Outport", Type.OutPortBlock);
        simuTypeToResType.put("Inport", Type.InPortBlock);
        simuTypeToResType.put("EnablePort", Type.EnableBlock);
        simuTypeToResType.put("TriggerPort", Type.TriggerBlock);
        simuTypeToResType.put("From", Type.From);
        simuTypeToResType.put("Goto", Type.Goto);
        simuTypeToResType.put("port", Type.Port);
        simuTypeToResType.put("inport", Type.InPort);
        simuTypeToResType.put("outport", Type.OutPort);
        simuTypeToResType.put("enable", Type.Trigger);
        simuTypeToResType.put("trigger", Type.Enable);

        portNameToPortBlockMap = HashBiMap.create();

        portNameToPortBlockMap.put("outport", "Outport");
        portNameToPortBlockMap.put("inport", "Inport");
        portNameToPortBlockMap.put("enable", "EnablePort");
        portNameToPortBlockMap.put("trigger", "TriggerPort");

        typeToResourceMap = new HashMap<>();
        Arrays.stream(Type.values()).forEach(
                t -> {
                    try {
                        typeToResourceMap.put(t, (Class<? extends AbstractResource>) Class
                                .forName("hu.bme.mit.massif.oslc.adaptor.resources." + t.name() + "Resource"));
                    } catch (final Exception e) {
                        e.printStackTrace();
                    }
                });

        builders = new HashMap<>();
        Arrays.stream(ResourceFactory.class.getDeclaredClasses())
                .filter(AbstractResourceBuilder.class::isAssignableFrom).forEach(c -> {
                    try {
                        final Class<?>[] empty = {};
                        final Constructor<?> ctr = c.getConstructor(empty);
                        final AbstractResourceBuilder b = (AbstractResourceBuilder) ctr.newInstance();
                        builders.put(b.getForClazz(), b);
                    } catch (final Exception e) {
                        e.printStackTrace();
                    }
                });
        // set up the hierarchy
        builders.values().forEach(b -> {
            final Class<?> superclass = b.getForClazz().getSuperclass();
            if (superclass != null && AbstractResource.class.isAssignableFrom(superclass))
                // noinspection SuspiciousMethodCalls
                b.setParent(builders.get(superclass));
        });
    }

    private static class Port {
        private final Type   type;
        private final double handle;

        public Port(final Type type, final double handle) {
            this.type = type;
            this.handle = handle;
        }
    }

    private static class SimulinkModelResourceBuilder extends AbstractResourceBuilder {

        public SimulinkModelResourceBuilder() {
            setForClazz(getResourceClass(Type.SimulinkModel));
        }

        @Override
        public void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final SimulinkModelResource resource = (SimulinkModelResource) ar;
            final String name = MatlabString.getMatlabStringData(commandFactory.getParam().addParam(id)
                    .addParam("name").execute());
            final String parent = MatlabString.getMatlabStringData(commandFactory.getParam().addParam(id)
                    .addParam("parent").execute());
            resource.setName(parent + "/" + name);

            final IVisitableMatlabData result0 = commandFactory.findSystem().addParam(id).addParam("SearchDepth")
                    .addParam(0.0).addParam("LookUnderMasks").addParam("all").addParam("FollowLinks").addParam("on")
                    .addParam("type").addParam("block").execute();
            final IVisitableMatlabData result1 = commandFactory.findSystem().addParam(id).addParam("SearchDepth")
                    .addParam(1.0).addParam("LookUnderMasks").addParam("all").addParam("FollowLinks").addParam("on")
                    .addParam("type").addParam("block").execute();
            CellMatlabData
                    .getCellMatlabDataData(result1)
                    .stream()
                    .map(MatlabString::getMatlabStringData)
                    .filter(subSystem -> !CellMatlabData.getCellMatlabDataData(result0).stream()
                            .anyMatch(topLevelSystems -> {
                                final String tlsName = MatlabString.getMatlabStringData(topLevelSystems);
                                return subSystem.equals(tlsName);
                            }))
                    .forEach(
                            block -> {
                                final String type = MatlabString.getMatlabStringData(commandFactory.getParam()
                                        .addParam(block).addParam("BlockType").execute());
                                resource.addContains(new Link(getBuilder(commandFactory, new MatlabString(block))
                                        .getAbout(IDHelper.refactorId(block), id)));
                            });

            final String version = MatlabString.getMatlabStringData(commandFactory.getParam().addParam(id)
                    .addParam("lastModifieddate").execute());
            resource.setVersion(version);

            final String file = MatlabString.getMatlabStringData(commandFactory.getParam().addParam(id)
                    .addParam("fileName").execute());
            resource.setFile(file);

            final String blockDiagramType = MatlabString.getMatlabStringData(
                    commandFactory.getParam().addParam(id).addParam("BlockDiagramType").execute()).toLowerCase();
            resource.setLibrary(blockDiagramType.equals("library"));
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new SimulinkModelResource();
        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<>();
            final IVisitableMatlabData result = commandFactory.findSystem().addParam("searchdepth").addParam(0.0)
                    .addParam("followlinks").addParam("on").execute();
            final List<IVisitableMatlabData> cellMatlabDataData = CellMatlabData.getCellMatlabDataData(result);
            cellMatlabDataData.stream().limit((page + 1) * limit + 1).skip(page * limit)
                    .map(MatlabString::getMatlabStringData).forEach(sysId -> ret.add(build(commandFactory, sysId, "")));
            return ret;
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return SimulinkModelResource.constructURI(IDHelper.refactorId(id));
        }
    }

    private static class SimulinkElementResourceBuilder extends AbstractResourceBuilder {

        public SimulinkElementResourceBuilder() {
            setForClazz(getResourceClass(Type.SimulinkElement));
        }

        @Override
        public void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final SimulinkElementResource resource = (SimulinkElementResource) ar;

            if (id.contains("$p$")) {
                final String name = id.substring(id.lastIndexOf("$p$") + 3);
                final Handle h = new Handle();

                resource.setName(name);
                resource.setSimulinkRef(id.replace("$p$", "/"));

            } else {
                String name = "";
                final IVisitableMatlabData matlabName = commandFactory.getParam().addParam(id).addParam("name")
                        .execute();
                if (matlabName instanceof MatlabString)
                    name = MatlabString.getMatlabStringData(matlabName);
                resource.setName(name);
                final String parentId = MatlabString.getMatlabStringData(commandFactory.getParam().addParam(id)
                        .addParam("parent").execute());
                resource.setName(name);
                resource.setSimulinkRef(parentId + "/" + name);
            }
        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<>();
            final List<PortResource> ports = ResourceFactory.collect(commandFactory, systemId + "Id", Type.Port, page,
                    limit);
            final List<PortResource> blocks = ResourceFactory.collect(commandFactory, systemId + "Id", Type.Block,
                    page, limit);
            ret.addAll(ports);
            ret.addAll(blocks);
            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new SimulinkElementResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return SimulinkElementResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }

    private static class BlockResourceBuilder extends AbstractResourceBuilder {

        public BlockResourceBuilder() {
            setForClazz(getResourceClass(Type.Block));
        }

        @SuppressWarnings("incomplete-switch")
        @Override
        public void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final BlockResource resource = (BlockResource) ar;
            final String parentId = MatlabString.getMatlabStringData(commandFactory.getParam().addParam(id)
                    .addParam("parent").execute());
            resource.setParent(new Link(getBuilder(commandFactory, new MatlabString(parentId)).getAbout(
                    IDHelper.refactorId(parentId), systemId)));
            final IVisitableMatlabData data = commandFactory.getParam().addParam(id).addParam("DialogParameters")
                    .execute();

            if (data instanceof StructMatlabData) {

                final Map<String, IVisitableMatlabData> dialogParamsStruct = StructMatlabData
                        .getStructMatlabDataData(data);

                final Set<String> dialogParameterNames = dialogParamsStruct.keySet();
                dialogParameterNames.forEach(paramName -> resource.addProperty(getParamData(commandFactory, id, data,
                        paramName)));
            } else if (data instanceof MatlabString) {
                final String paramName = MatlabString.getMatlabStringData(data);

                resource.addProperty(getParamData(commandFactory, id, data, paramName));
            }

            final String sourceBlock = MatlabString.getMatlabStringData(commandFactory.getParam().addParam(id)
                    .addParam("ReferenceBlock").execute());
            if (!sourceBlock.isEmpty() && sourceBlock.contains("/")) {
                final String sourceLibrary = sourceBlock.substring(0, sourceBlock.indexOf('/')) + "Id";
                resource.setSourceBlock(new Link(getBuilder(commandFactory, new MatlabString(sourceBlock)).getAbout(
                        IDHelper.refactorId(sourceBlock), sourceLibrary)));
            } else {
                resource.setSourceBlock(new Link());
            }

            final List<Port> portData = getPortData(commandFactory.getParam().addParam(id).addParam("PortHandles")
                    .execute());
            portData.forEach(p -> {
                final Link link = new Link(getBuilder(p.type).getAbout(
                        id + "$p$" + handleToId(commandFactory, p.handle), systemId));
                switch (p.type) {
                case InPort:
                    resource.addInports(link);
                    break;
                case OutPort:
                    resource.addOutports(link);
                    break;
                case Enable:
                    resource.setEnabler(link);
                    break;
                case Trigger:
                    resource.setTrigger(link);
                    break;
                }
            });
        }

        private String getParamData(final MatlabCommandFactory commandFactory, final String id,
                final IVisitableMatlabData data, final String paramName) {
            final IVisitableMatlabData valueData = commandFactory.getParam().addParam(id).addParam(paramName).execute();

            if (valueData instanceof MatlabString) {
                final String value = MatlabString.getMatlabStringData(valueData);
                return String.format("%s : %s", paramName, value);
            } else {
                return String.format("%s : %s", paramName, "");
            }
        }

        private List<Port> getPortData(final IVisitableMatlabData data) {
            final List<Port> ports = new ArrayList<>();
            if (data instanceof MatlabString)
                return ports;

            final Map<String, IVisitableMatlabData> struct = StructMatlabData.getStructMatlabDataData(data);

            IVisitableMatlabData portData;

            portData = struct.get("Inport");
            ports.addAll(getPortData(Type.InPort, portData));
            portData = struct.get("Outport");
            ports.addAll(getPortData(Type.OutPort, portData));
            portData = struct.get("Trigger");
            ports.addAll(getPortData(Type.Trigger, portData));
            portData = struct.get("Enable");
            ports.addAll(getPortData(Type.Enable, portData));

            return ports;
        }

        private List<Port> getPortData(final Type type, final IVisitableMatlabData data) {
            final List<Port> ports = new ArrayList<>();

            if (data instanceof Handle)
                ports.add(new Port(type, ((Handle) data).getData()));
            else {
                final List<IVisitableMatlabData> portDatas = CellMatlabData.getCellMatlabDataData(data);
                portDatas.forEach(p -> ports.add(new Port(type, ((Handle) p).getData())));
            }

            return ports;
        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<>();
            final IVisitableMatlabData result = commandFactory.findSystem().addParam(systemId)
                    .addParam("lookundermasks").addParam("all").addParam("followlinks").addParam("on").addParam("type")
                    .addParam("Block").execute();
            final List<IVisitableMatlabData> cellMatlabDataData = CellMatlabData.getCellMatlabDataData(result);
            cellMatlabDataData
                    .stream()
                    .limit((page + 1) * limit + 1)
                    .skip(page * limit)
                    .map(MatlabString::getMatlabStringData)
                    .forEach(
                            id -> ret.add(getBuilder(commandFactory, new MatlabString(id)).build(commandFactory, id,
                                    systemId)));
            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new BlockResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return BlockResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }

    private static class SubSystemResourceBuilder extends AbstractResourceBuilder {

        public SubSystemResourceBuilder() {
            setForClazz(getResourceClass(Type.SubSystem));
        }

        @Override
        public void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final SubSystemResource resource = (SubSystemResource) ar;

            final IVisitableMatlabData subBlocks = commandFactory.findSystem().addParam(id).addParam("lookundermasks")
                    .addParam("all").addParam("SearchDepth").addParam(1.0).addParam("FollowLinks").addParam("On")
                    .addParam("Type").addParam("Block").execute();
            CellMatlabData.getCellMatlabDataData(subBlocks).stream().map(MatlabString::getMatlabStringData)
                    .filter(block -> !block.equals(id)).forEach(sb -> {
                        final AbstractResourceBuilder builder = getBuilder(commandFactory, new MatlabString(sb));
                        final Link subBlock = new Link(builder.getAbout(sb, systemId));
                        resource.addSubBlocks(subBlock);
                    });
            final String tag = MatlabString.getMatlabStringData(commandFactory.getParam().addParam(id).addParam("tag")
                    .execute());
            resource.setTag(tag);
        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<>();
            final IVisitableMatlabData result = commandFactory.findSystem().addParam(systemId)
                    .addParam("lookundermasks").addParam("all").addParam("followlinks").addParam("on").addParam("type")
                    .addParam("Block").addParam("BlockType").addParam("SubSystem").execute();
            final List<IVisitableMatlabData> cellMatlabDataData = CellMatlabData.getCellMatlabDataData(result);
            cellMatlabDataData.stream().limit((page + 1) * limit + 1).skip(page * limit)
                    .map(MatlabString::getMatlabStringData).forEach(id -> ret.add(build(commandFactory, id, systemId)));
            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new SubSystemResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return SubSystemResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }

    public static class BusSpecificationResourceBuilder extends AbstractResourceBuilder {
        public BusSpecificationResourceBuilder() {
            setForClazz(getResourceClass(Type.BusSpecification));
        }

        @Override
        protected void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final BusSpecificationResource resource = (BusSpecificationResource) ar;
        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<>();
            final IVisitableMatlabData result = commandFactory.findSystem().addParam(systemId)
                    .addParam("lookundermasks").addParam("all").addParam("followlinks").addParam("on")
                    .addParam("Regexp").addParam("on").addParam("type").addParam("Block").addParam("BlockType")
                    .addParam("(BusSelector|BusCreator)").execute();
            final List<IVisitableMatlabData> cellMatlabDataData = CellMatlabData.getCellMatlabDataData(result);
            cellMatlabDataData.stream().limit((page + 1) * limit + 1).skip(page * limit)
                    .map(MatlabString::getMatlabStringData).forEach(id -> ret.add(build(commandFactory, id, systemId)));
            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new BusSpecificationResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return BusSelectorResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }

    public static class BusSelectorResourceBuilder extends AbstractResourceBuilder {
        public BusSelectorResourceBuilder() {
            setForClazz(getResourceClass(Type.BusSelector));
        }

        @Override
        protected void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final BusSelectorResource resource = (BusSelectorResource) ar;
        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<>();
            final IVisitableMatlabData result = commandFactory.findSystem().addParam(systemId)
                    .addParam("lookundermasks").addParam("all").addParam("followlinks").addParam("on").addParam("type")
                    .addParam("Block").addParam("BlockType").addParam("BusSelector").execute();
            final List<IVisitableMatlabData> cellMatlabDataData = CellMatlabData.getCellMatlabDataData(result);
            cellMatlabDataData.stream().limit((page + 1) * limit + 1).skip(page * limit)
                    .map(MatlabString::getMatlabStringData).forEach(id -> ret.add(build(commandFactory, id, systemId)));
            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new BusSelectorResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return BusSelectorResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }

    public static class BusCreatorResourceBuilder extends AbstractResourceBuilder {
        public BusCreatorResourceBuilder() {
            setForClazz(getResourceClass(Type.BusCreator));
        }

        @Override
        protected void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final BusCreatorResource resource = (BusCreatorResource) ar;
        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<>();
            final IVisitableMatlabData result = commandFactory.findSystem().addParam(systemId)
                    .addParam("lookundermasks").addParam("all").addParam("followlinks").addParam("on").addParam("type")
                    .addParam("Block").addParam("BlockType").addParam("BusCreator").execute();
            final List<IVisitableMatlabData> cellMatlabDataData = CellMatlabData.getCellMatlabDataData(result);
            cellMatlabDataData.stream().limit((page + 1) * limit + 1).skip(page * limit)
                    .map(MatlabString::getMatlabStringData).forEach(id -> ret.add(build(commandFactory, id, systemId)));
            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new BusCreatorResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return BusSelectorResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }

    private static class VirtualBlockResourceBuilder extends AbstractResourceBuilder {

        public VirtualBlockResourceBuilder() {
            setForClazz(getResourceClass(Type.VirtualBlock));
        }

        @Override
        public void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final VirtualBlockResource resource = (VirtualBlockResource) ar;
        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<>();
            final IVisitableMatlabData result = commandFactory.findSystem().addParam(systemId).addParam("searchdepth")
                    .addParam(0.0).execute();
            final List<IVisitableMatlabData> cellMatlabDataData = CellMatlabData.getCellMatlabDataData(result);
            cellMatlabDataData.stream().limit((page + 1) * limit + 1).skip(page * limit)
                    .map(MatlabString::getMatlabStringData).forEach(id -> ret.add(build(commandFactory, id, systemId)));
            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new VirtualBlockResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return VirtualBlockResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }

    private static class PortBlockResourceBuilder extends AbstractResourceBuilder {

        public PortBlockResourceBuilder() {
            setForClazz(getResourceClass(Type.PortBlock));
        }

        @Override
        public void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final PortBlockResource resource = (PortBlockResource) ar;
            final String portType = MatlabString.getMatlabStringData(commandFactory.getParam().addParam(id)
                    .addParam("blocktype").execute());
            final IVisitableMatlabData parent = commandFactory.getParam().addParam(id).addParam("parent").execute();

            final MatlabCommand command = commandFactory.findSystem().addParam(parent).addParam("findall")
                    .addParam("on").addParam("searchdepth").addParam("0").addParam("type").addParam("port")
                    .addParam("porttype").addParam(portNameToPortBlockMap.inverse().get(portType));

            if (portType.equals("inport") || portType.equals("outport")) {
                final double portNumber = Double.parseDouble(MatlabString.getMatlabStringData(commandFactory.getParam()
                        .addParam(id).addParam("port").execute()));
                command.addParam("PortNumber").addParam(portNumber);
            }

            final IVisitableMatlabData data = command.execute();
            Double handleData;
            if (data instanceof Handle) {
                handleData = Handle.getHandleData(data);
                final Port port = new Port(Type.valueOf(simuTypeToResType.get(portType).name().split("Block")[0]),
                        handleData);

                resource.setPort(new Link(getBuilder(port.type).getAbout(
                        MatlabString.getMatlabStringData(parent) + "$p$" + handleToId(commandFactory, port.handle),
                        systemId)));
            }
        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<>();
            final IVisitableMatlabData result = commandFactory.findSystem().addParam(systemId).addParam("Regexp")
                    .addParam("On").addParam("lookundermasks").addParam("all").addParam("followlinks").addParam("on")
                    .addParam("type").addParam("block").addParam("blocktype")
                    .addParam("(Inport|Outport|EnablePort|TriggerPort)").execute();
            final List<IVisitableMatlabData> cellMatlabDataData = CellMatlabData.getCellMatlabDataData(result);
            cellMatlabDataData
                    .stream()
                    .limit((page + 1) * limit + 1)
                    .skip(page * limit)
                    .forEach(
                            id -> ret.add(getBuilder(commandFactory, id).build(commandFactory,
                                    MatlabString.getMatlabStringData(id), systemId)));
            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new PortBlockResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return PortBlockResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }

    private static class OutPortBlockResourceBuilder extends AbstractResourceBuilder {

        public OutPortBlockResourceBuilder() {
            setForClazz(getResourceClass(Type.OutPortBlock));
        }

        @Override
        public void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final OutPortBlockResource resource = (OutPortBlockResource) ar;

        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<>();
            final IVisitableMatlabData result = commandFactory.findSystem().addParam(systemId)
                    .addParam("lookundermasks").addParam("all").addParam("followlinks").addParam("on").addParam("type")
                    .addParam("block").addParam("blocktype").addParam("Outport").execute();
            final List<IVisitableMatlabData> cellMatlabDataData = CellMatlabData.getCellMatlabDataData(result);
            cellMatlabDataData.stream().limit((page + 1) * limit + 1).skip(page * limit)
                    .map(MatlabString::getMatlabStringData).forEach(id -> ret.add(build(commandFactory, id, systemId)));
            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new OutPortBlockResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return OutPortBlockResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }

    private static class InPortBlockResourceBuilder extends AbstractResourceBuilder {

        public InPortBlockResourceBuilder() {
            setForClazz(getResourceClass(Type.InPortBlock));
        }

        @Override
        public void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final InPortBlockResource resource = (InPortBlockResource) ar;

        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<>();
            final IVisitableMatlabData result = commandFactory.findSystem().addParam(systemId)
                    .addParam("lookundermasks").addParam("all").addParam("followlinks").addParam("on").addParam("type")
                    .addParam("block").addParam("blocktype").addParam("Inport").execute();
            final List<IVisitableMatlabData> cellMatlabDataData = CellMatlabData.getCellMatlabDataData(result);
            cellMatlabDataData.stream().limit((page + 1) * limit + 1).skip(page * limit)
                    .map(MatlabString::getMatlabStringData).forEach(id -> ret.add(build(commandFactory, id, systemId)));
            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new InPortBlockResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return InPortBlockResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }

    private static class EnableBlockResourceBuilder extends AbstractResourceBuilder {

        public EnableBlockResourceBuilder() {
            setForClazz(getResourceClass(Type.EnableBlock));
        }

        @Override
        public void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final EnableBlockResource resource = (EnableBlockResource) ar;

        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<>();
            final IVisitableMatlabData result = commandFactory.findSystem().addParam(systemId)
                    .addParam("lookundermasks").addParam("all").addParam("followlinks").addParam("on").addParam("type")
                    .addParam("block").addParam("blocktype").addParam("EnablePort").execute();
            final List<IVisitableMatlabData> cellMatlabDataData = CellMatlabData.getCellMatlabDataData(result);
            cellMatlabDataData.stream().limit((page + 1) * limit + 1).skip(page * limit)
                    .map(MatlabString::getMatlabStringData).forEach(id -> ret.add(build(commandFactory, id, systemId)));
            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new EnableBlockResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return EnableBlockResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }

    private static class TriggerBlockResourceBuilder extends AbstractResourceBuilder {

        public TriggerBlockResourceBuilder() {
            setForClazz(getResourceClass(Type.TriggerBlock));
        }

        @Override
        public void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final TriggerBlockResource resource = (TriggerBlockResource) ar;

        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<AbstractResource>();
            final IVisitableMatlabData result = commandFactory.findSystem().addParam(systemId)
                    .addParam("lookundermasks").addParam("all").addParam("followlinks").addParam("on").addParam("type")
                    .addParam("block").addParam("blocktype").addParam("TriggerPort").execute();
            final List<IVisitableMatlabData> cellMatlabDataData = CellMatlabData.getCellMatlabDataData(result);
            cellMatlabDataData.stream().limit((page + 1) * limit + 1).skip(page * limit)
                    .map(MatlabString::getMatlabStringData).forEach(id -> ret.add(build(commandFactory, id, systemId)));
            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new TriggerBlockResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return TriggerBlockResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }

    private static class GotoResourceBuilder extends AbstractResourceBuilder {

        public GotoResourceBuilder() {
            setForClazz(getResourceClass(Type.Goto));
        }

        @Override
        public void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final GotoResource resource = (GotoResource) ar;

            final String tagVisibility = MatlabString.getMatlabStringData(commandFactory.getParam().addParam(id)
                    .addParam("TagVisibility").execute());
            resource.setTagVisibility(tagVisibility);

            final String gotoTag = MatlabString.getMatlabStringData(commandFactory.getParam().addParam(id)
                    .addParam("GotoTag").execute());
            resource.setGotoTag(gotoTag);

            final IVisitableMatlabData handle = commandFactory.getParam().addParam(id).addParam("Handle").execute();
            final List<IVisitableMatlabData> fromNamesAndHandles = CellMatlabData.getCellMatlabDataData(commandFactory
                    .get().addParam(handle).addParam("FromBlock").execute());
            fromNamesAndHandles.forEach(fnah -> {
                if (fnah == null)
                    return;
                final String name = MatlabString.getMatlabStringData(StructMatlabData.getStructMatlabDataData(fnah)
                        .get("name"));
                resource.addFromBlocks(new Link(getBuilder(Type.From).getAbout(name, systemId)));
            });
        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<>();
            final IVisitableMatlabData result = commandFactory.findSystem().addParam(systemId)
                    .addParam("lookundermasks").addParam("all").addParam("followlinks").addParam("on").addParam("type")
                    .addParam("block").addParam("blocktype").addParam("Goto").execute();
            final List<IVisitableMatlabData> cellMatlabDataData = CellMatlabData.getCellMatlabDataData(result);
            cellMatlabDataData.stream().limit((page + 1) * limit + 1).skip(page * limit)
                    .map(MatlabString::getMatlabStringData).forEach(id -> ret.add(build(commandFactory, id, systemId)));
            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new GotoResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return GotoResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }

    private static class FromResourceBuilder extends AbstractResourceBuilder {

        public FromResourceBuilder() {
            setForClazz(getResourceClass(Type.From));
        }

        @Override
        public void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final FromResource resource = (FromResource) ar;

            final IVisitableMatlabData handle = commandFactory.getParam().addParam(id).addParam("Handle").execute();
            final Map<String, IVisitableMatlabData> gotoNamesAndHandles = StructMatlabData
                    .getStructMatlabDataData(commandFactory.get().addParam(handle).addParam("GotoBlock").execute());

            final String name = MatlabString.getMatlabStringData(gotoNamesAndHandles.get("name"));
            resource.setGotoBlock(new Link(getBuilder(Type.Goto).getAbout(name, systemId)));

        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<AbstractResource>();
            final IVisitableMatlabData result = commandFactory.findSystem().addParam(systemId)
                    .addParam("lookundermasks").addParam("all").addParam("followlinks").addParam("on").addParam("type")
                    .addParam("block").addParam("blocktype").addParam("From").execute();
            final List<IVisitableMatlabData> cellMatlabDataData = CellMatlabData.getCellMatlabDataData(result);
            cellMatlabDataData.stream().limit((page + 1) * limit + 1).skip(page * limit)
                    .map(MatlabString::getMatlabStringData).forEach(id -> {
                        ret.add(build(commandFactory, id, systemId));
                    });
            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new FromResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return FromResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }

    private static class PortResourceBuilder extends AbstractResourceBuilder {

        public PortResourceBuilder() {
            setForClazz(getResourceClass(Type.Port));
        }

        private static void processConnections(final PortResource resource, final MatlabCommandFactory commandFactory,
                final List<IVisitableMatlabData> blocks, final List<IVisitableMatlabData> ports, final String filter,
                final String systemId) {
            final ParallelIterator<IVisitableMatlabData, IVisitableMatlabData> iterator = ParallelIterator.of(blocks,
                    ports);

            iterator.forEachRemaining(portData -> {
                final Handle blockHandle = Handle.asHandle(portData.getV1());
                final Double targetPortNumber = Handle.getHandleData(portData.getV2()) + 1;

                final IVisitableMatlabData foundPorts = commandFactory.findSystem().addParam(blockHandle)
                        .addParam("findall").addParam("on").addParam("searchdepth").addParam("0").addParam("RegExp")
                        .addParam("on").addParam("PortType").addParam(filter).execute();

                final List<IVisitableMatlabData> portList = getData(foundPorts);
                final Optional<Handle> destPort = portList
                        .stream()
                        .filter(p -> {
                            final Double n = Handle.getHandleData(commandFactory.getParam().addParam(p)
                                    .addParam("PortNumber").execute());
                            return targetPortNumber.equals(n);
                        }).map(Handle::asHandle).findAny();

                destPort.ifPresent(p -> {
                    final String blockName = MatlabString.getMatlabStringData(commandFactory.getFullName()
                            .addParam(blockHandle).execute());
                    final String type = MatlabString.getMatlabStringData(commandFactory.getParam().addParam(p)
                            .addParam("PortType").execute());
                    Type ty = null;
                    if (type.equals("inport"))
                        ty = Type.InPort;
                    if (type.equals("enable"))
                        ty = Type.Enable;
                    if (type.equals("trigger"))
                        ty = Type.Trigger;
                    if (type.equals("outport"))
                        ty = Type.OutPort;
                    resource.addConnections(new Link(getBuilder(ty).getAbout(
                            blockName + "$p$" + handleToId(commandFactory, p.getData()), systemId)));
                });
            });
        }

        private static Port getPortData(final IVisitableMatlabData data) {
            Port port = null;
            final Map<String, IVisitableMatlabData> ports = StructMatlabData.getStructMatlabDataData(data);

            final IVisitableMatlabData inPortsData = ports.get("Inport");
            final IVisitableMatlabData outPortsData = ports.get("Outport");
            final IVisitableMatlabData enableData = ports.get("Enable");
            final IVisitableMatlabData triggerData = ports.get("Trigger");

            if (inPortsData instanceof Handle) {
                port = new Port(Type.InPort, ((Handle) inPortsData).getData());
            } else if (outPortsData instanceof Handle) {
                port = new Port(Type.OutPort, ((Handle) outPortsData).getData());
            } else if (enableData instanceof Handle) {
                port = new Port(Type.Enable, ((Handle) enableData).getData());
            } else if (triggerData instanceof Handle) {
                port = new Port(Type.Trigger, ((Handle) triggerData).getData());
            }

            return port;
        }

        private static List<IVisitableMatlabData> getData(final IVisitableMatlabData data) {
            final List<IVisitableMatlabData> l = new ArrayList<>();
            if (data instanceof CellMatlabData)
                l.addAll(((CellMatlabData) data).getDatas());
            else
                l.add(data);

            return l;
        }

        private static void processStructs(final List<StructMatlabData> data, final List<StructMatlabData> inports,
                final List<StructMatlabData> outports, final Reference<StructMatlabData> enable,
                final Reference<StructMatlabData> trigger) {
            List<StructMatlabData> listToWrite = inports;
            final Iterator<StructMatlabData> dataIterator = data.iterator();
            StructMatlabData s;
            String type;
            boolean firstOneFound = false;
            while (dataIterator.hasNext()) {
                s = dataIterator.next();
                type = MatlabString.getMatlabStringData(s.getData("Type"));
                if (!Utils.isNumber(type)) {
                    switch (type) {
                    case "enable":
                        enable.setValue(s);
                        break;
                    case "trigger":
                        trigger.setValue(s);
                        break;
                    }
                    listToWrite = outports;
                } else {
                    if (firstOneFound && Integer.parseInt(type) == 1) {
                        listToWrite = outports;
                    }
                    if (!firstOneFound && Integer.parseInt(type) == 1) {
                        firstOneFound = true;
                        if (CellMatlabData.getCellMatlabDataData(s.getData("SrcBlock")).isEmpty())
                            listToWrite = outports;
                    }
                    listToWrite.add(s);
                }
            }
        }

        @Override
        public void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final PortResource resource = (PortResource) ar;

            final int pos = id.lastIndexOf("$p$");
            final String containerId = id.substring(0, pos);
            final String portId = id.substring(pos + 3);
            String portType = portNameToPortBlockMap.get(getPortType(portId));
            final int portNumber = getPortNumber(portId);

            if (!simuTypeToResType.containsKey(portType)) {
                portType = "Port";
            }

            String portBlockId;

            final MatlabCommand command = commandFactory.findSystem().addParam(containerId).addParam("searchdepth")
                    .addParam("1").addParam("lookundermasks").addParam("all").addParam("BlockType").addParam(portType);

            if (portType.equals("Inport") || portType.equals("Outport"))
                command.addParam("Port").addParam(portNumber + "");

            final List<IVisitableMatlabData> portBlockList = CellMatlabData.getCellMatlabDataData((command.execute()));
            if (portBlockList.size() == 1) {

                portBlockId = MatlabString.getMatlabStringData(portBlockList.get(0));

                final Link portBlockLink = new Link(getBuilder(commandFactory, new MatlabString(portBlockId)).getAbout(
                        portBlockId, systemId));
                resource.setPortBlock(portBlockLink);
            }

            resource.setContainer(new Link(getBuilder(commandFactory, new MatlabString(containerId)).getAbout(
                    containerId, systemId)));

            final IVisitableMatlabData execute = commandFactory.getParam().addParam(containerId)
                    .addParam("PortConnectivity").execute();

            final List<StructMatlabData> inports = new ArrayList<>();
            final List<StructMatlabData> outports = new ArrayList<>();
            final StructMatlabData enable = null;
            final StructMatlabData trigger = null;
            final Reference<StructMatlabData> e = new Reference<>();
            final Reference<StructMatlabData> t = new Reference<>();
            e.setValue(enable);
            t.setValue(trigger);
            List<StructMatlabData> data;

            if (execute instanceof CellMatlabData) {
                data = CellMatlabData.getCellMatlabDataData(execute).stream().map(StructMatlabData::asStructMatlabData)
                        .collect(Collectors.toList());
            } else if (execute instanceof StructMatlabData) {
                data = new ArrayList<>();
                data.add(StructMatlabData.asStructMatlabData(execute));
            } else {
                data = null;
            }

            if (data != null) {
                processStructs(data, inports, outports, e, t);

                StructMatlabData correctPortStruct = null;

                if (portType.equals("EnablePort"))
                    correctPortStruct = e.getValue();
                if (portType.equals("TriggerPort"))
                    correctPortStruct = t.getValue();
                if (portType.equals("Inport")) {
                    final int idx = portNumber - 1;
                    if (inports.size() > idx)
                        correctPortStruct = inports.get(idx);
                }
                if (portType.equals("Outport")) {
                    final int idx = portNumber - 1;
                    if (outports.size() > idx)
                        correctPortStruct = outports.get(idx);
                }

                final List<IVisitableMatlabData> dstBlocks = getData(correctPortStruct.getData("DstBlock"));
                final List<IVisitableMatlabData> dstPorts = getData(correctPortStruct.getData("DstPort"));
                final List<IVisitableMatlabData> srcBlocks = getData(correctPortStruct.getData("SrcBlock"));
                final List<IVisitableMatlabData> srcPorts = getData(correctPortStruct.getData("SrcPort"));

                if (portType.equals("EnablePort") || portType.equals("TriggerPort") || portType.equals("Inport")) {
                } else {
                    processConnections(resource, commandFactory, dstBlocks, dstPorts, "(inport|enable|trigger)",
                            systemId);
                }

            }
        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<>();
            final CellMatlabData resultHandles = CellMatlabData.asCellMatlabData(commandFactory.findSystem()
                    .addParam(systemId).addParam("findall").addParam("on").addParam("followlinks").addParam("on")
                    .addParam("lookundermasks").addParam("all").addParam("type").addParam("port").execute());
            resultHandles.setDatas(CellMatlabData.getCellMatlabDataData(resultHandles).stream()
                    .limit((page + 1) * limit + 1).skip(page * limit).collect(Collectors.toList()));

            final IVisitableMatlabData portContainers = commandFactory.getParam().addParam(resultHandles)
                    .addParam("Parent").execute();
            final List<Double> handleList = CellMatlabData.getCellMatlabDataData(resultHandles).stream()
                    .map(Handle::getHandleData).collect(Collectors.toList());
            final List<String> contList = CellMatlabData.getCellMatlabDataData(portContainers).stream()
                    .map(MatlabString::getMatlabStringData).collect(Collectors.toList());

            final ParallelIterator<String, Double> i = ParallelIterator.of(contList, handleList);

            i.forEachRemaining(p -> {
                final String cont = p.getV1();
                final Double handle = p.getV2();
                ret.add(getBuilder(commandFactory, new Handle(handle)).build(commandFactory,
                        cont + "$p$" + handleToId(commandFactory, handle), systemId));
            });

            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new PortResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return PortResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }

    private static class InPortResourceBuilder extends AbstractResourceBuilder {

        public InPortResourceBuilder() {
            setForClazz(getResourceClass(Type.InPort));
        }

        @Override
        public void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final InPortResource resource = (InPortResource) ar;

        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<>();
            final IVisitableMatlabData resultHandles = commandFactory.findSystem().addParam(systemId)
                    .addParam("findall").addParam("on").addParam("followlinks").addParam("on")
                    .addParam("lookundermasks").addParam("all").addParam("type").addParam("port").addParam("porttype")
                    .addParam("inport").execute();
            final IVisitableMatlabData portContainers = commandFactory.getParam().addParam(resultHandles)
                    .addParam("Parent").execute();
            final List<Double> handleList = CellMatlabData.getCellMatlabDataData(resultHandles).stream()
                    .map(Handle::getHandleData).collect(Collectors.toList());
            final List<String> contList = CellMatlabData.getCellMatlabDataData(portContainers).stream()
                    .map(MatlabString::getMatlabStringData).collect(Collectors.toList());

            final ParallelIterator<String, Double> i = ParallelIterator.of(contList, handleList);

            i.forEachRemaining(p -> {
                final String cont = p.getV1();
                final Double handle = p.getV2();
                ret.add(build(commandFactory, cont + "$p$" + handleToId(commandFactory, handle), systemId));
            });

            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new InPortResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return InPortResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }

    private static class OutPortResourceBuilder extends AbstractResourceBuilder {

        public OutPortResourceBuilder() {
            setForClazz(getResourceClass(Type.OutPort));
        }

        @Override
        public void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final OutPortResource resource = (OutPortResource) ar;

        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<>();
            final IVisitableMatlabData resultHandles = commandFactory.findSystem().addParam(systemId)
                    .addParam("findall").addParam("on").addParam("followlinks").addParam("on")
                    .addParam("lookundermasks").addParam("all").addParam("type").addParam("port").addParam("porttype")
                    .addParam("outport").execute();
            final IVisitableMatlabData portContainers = commandFactory.getParam().addParam(resultHandles)
                    .addParam("Parent").execute();
            final List<Double> handleList = CellMatlabData.getCellMatlabDataData(resultHandles).stream()
                    .map(Handle::getHandleData).collect(Collectors.toList());
            final List<String> contList = CellMatlabData.getCellMatlabDataData(portContainers).stream()
                    .map(MatlabString::getMatlabStringData).collect(Collectors.toList());

            final ParallelIterator<String, Double> i = ParallelIterator.of(contList, handleList);

            i.forEachRemaining(p -> {
                final String cont = p.getV1();
                final Double handle = p.getV2();
                ret.add(build(commandFactory, cont + "$p$" + handleToId(commandFactory, handle), systemId));
            });

            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new OutPortResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return OutPortResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }

    private static class EnableResourceBuilder extends AbstractResourceBuilder {

        public EnableResourceBuilder() {
            setForClazz(getResourceClass(Type.Enable));
        }

        @Override
        public void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final EnableResource resource = (EnableResource) ar;

        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<>();
            final IVisitableMatlabData resultHandles = commandFactory.findSystem().addParam(systemId)
                    .addParam("findall").addParam("on").addParam("followlinks").addParam("on")
                    .addParam("lookundermasks").addParam("all").addParam("type").addParam("port").addParam("porttype")
                    .addParam("enable").execute();
            final IVisitableMatlabData portContainers = commandFactory.getParam().addParam(resultHandles)
                    .addParam("Parent").execute();
            final List<Double> handleList = CellMatlabData.getCellMatlabDataData(resultHandles).stream()
                    .map(Handle::getHandleData).collect(Collectors.toList());
            final List<String> contList = CellMatlabData.getCellMatlabDataData(portContainers).stream()
                    .map(MatlabString::getMatlabStringData).collect(Collectors.toList());

            final ParallelIterator<String, Double> i = ParallelIterator.of(contList, handleList);

            i.forEachRemaining(p -> {
                final String cont = p.getV1();
                final Double handle = p.getV2();
                ret.add(build(commandFactory, cont + "$p$" + handleToId(commandFactory, handle), systemId));
            });

            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new EnableResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return EnableResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }

    private static class TriggerResourceBuilder extends AbstractResourceBuilder {

        public TriggerResourceBuilder() {
            setForClazz(getResourceClass(Type.Trigger));
        }

        @Override
        public void buildResource(final MatlabCommandFactory commandFactory, final String id, final String systemId,
                final AbstractResource ar) {
            final TriggerResource resource = (TriggerResource) ar;
        }

        @Override
        public List<AbstractResource> collect(final MatlabCommandFactory commandFactory, final String systemId,
                final int page, final int limit) {
            final List<AbstractResource> ret = new ArrayList<>();
            final IVisitableMatlabData resultHandles = commandFactory.findSystem().addParam(systemId)
                    .addParam("findall").addParam("on").addParam("followlinks").addParam("on")
                    .addParam("lookundermasks").addParam("all").addParam("type").addParam("port").addParam("porttype")
                    .addParam("trigger").execute();
            final IVisitableMatlabData portContainers = commandFactory.getParam().addParam(resultHandles)
                    .addParam("Parent").execute();
            final List<Double> handleList = CellMatlabData.getCellMatlabDataData(resultHandles).stream()
                    .map(Handle::getHandleData).collect(Collectors.toList());
            final List<String> contList = CellMatlabData.getCellMatlabDataData(portContainers).stream()
                    .map(MatlabString::getMatlabStringData).collect(Collectors.toList());

            final ParallelIterator<String, Double> i = ParallelIterator.of(contList, handleList);

            i.forEachRemaining(p -> {
                final String cont = p.getV1();
                final Double handle = p.getV2();
                ret.add(build(commandFactory, cont + "$p$" + handleToId(commandFactory, handle), systemId));
            });

            return ret;
        }

        @Override
        public AbstractResource newInstance() throws URISyntaxException {
            return new TriggerResource();
        }

        @Override
        public URI getAbout(final String id, final String systemId) {
            return TriggerResource.constructURI(systemId, IDHelper.refactorId(id));
        }
    }
}