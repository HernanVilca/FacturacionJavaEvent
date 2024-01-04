package pe.wds.Facturacion.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class RollbackDebitBankAccountCmd {
    @TargetAggregateIdentifier
    private String aggregateId;
    private Integer amount;

    public RollbackDebitBankAccountCmd(){}
}
