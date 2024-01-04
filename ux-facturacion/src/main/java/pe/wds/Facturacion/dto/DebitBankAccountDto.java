package pe.wds.Facturacion.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DebitBankAccountDto {
    private String aggregateId;
    private Integer amount;
    private String userTransferId;
}
