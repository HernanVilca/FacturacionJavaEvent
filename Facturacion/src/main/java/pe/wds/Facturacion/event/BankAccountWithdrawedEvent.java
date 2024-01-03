package pe.wds.Facturacion.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class BankAccountWithdrawedEvent {
    
    private String aggregateId;
    private Integer amount;

    public BankAccountWithdrawedEvent(){}
}
