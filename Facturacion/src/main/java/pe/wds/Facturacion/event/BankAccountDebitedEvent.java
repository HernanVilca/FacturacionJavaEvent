package pe.wds.Facturacion.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class BankAccountDebitedEvent {
    
    private String aggregateId;
    private Integer amount;
    private String userTransferId;

    public BankAccountDebitedEvent(){}
}
