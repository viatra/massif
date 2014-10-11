package hu.bme.mit.massif.simulink.api.layout;

import hu.bme.mit.massif.simulink.Block;

import java.util.Map;

public interface IExporterLayoutProvider {
    
    void updateSpecifications(Map<Block, BlockLayoutSpecification> bls);
    
}
