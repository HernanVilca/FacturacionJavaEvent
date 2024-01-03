package pe.wds.Facturacion.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateBankAccountCmd {
    
    @TargetAggregateIdentifier
    private String aggregateId;
    private String userId;
    
    public CreateBankAccountCmd(){}

}