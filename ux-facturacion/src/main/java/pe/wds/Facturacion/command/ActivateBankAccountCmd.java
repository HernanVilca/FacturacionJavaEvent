package pe.wds.Facturacion.command;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class ActivateBankAccountCmd {

    @TargetAggregateIdentifier
    private String aggregateId;

    public ActivateBankAccountCmd(){}
}
