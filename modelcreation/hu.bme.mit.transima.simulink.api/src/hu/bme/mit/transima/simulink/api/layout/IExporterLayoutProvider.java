package hu.bme.mit.transima.simulink.api.layout;

import hu.bme.mit.transima.Simulink.Block;

import java.util.Map;

public interface IExporterLayoutProvider {
    
    void updateSpecifications(Map<Block, BlockLayoutSpecification> bls);
    
}
