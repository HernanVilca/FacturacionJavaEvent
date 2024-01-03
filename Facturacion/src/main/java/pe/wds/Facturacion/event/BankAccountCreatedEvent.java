package pe.wds.Facturacion.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BankAccountCreatedEvent {
    private String aggregateId;
    private String userId;

    public BankAccountCreatedEvent(){}
    
}
