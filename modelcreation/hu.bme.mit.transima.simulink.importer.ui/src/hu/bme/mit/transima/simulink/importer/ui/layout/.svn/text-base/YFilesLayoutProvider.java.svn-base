package hu.bme.mit.transima.simulink.importer.ui.layout;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.simulink.api.layout.BlockLayoutSpecification;
import hu.bme.mit.transima.simulink.api.layout.IExporterLayoutProvider;

import java.util.Map;

public class YFilesLayoutProvider implements IExporterLayoutProvider{

	@Override
    public void updateSpecifications(Map<Block, BlockLayoutSpecification> bls) {
		GraphHandler graph = new GraphHandler();
		graph.processSameLevelBlocks(bls);
	}
}
