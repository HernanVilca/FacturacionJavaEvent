package pe.wds.Facturacion.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BankAccountActivatedEvent {

    private String aggregateId;
    private String status;
    
    public BankAccountActivatedEvent(){}
    
}
