package pe.wds.Facturacion.saga;

import java.util.UUID;

import org.axonframework.commandhandling.CommandResultMessage;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import pe.wds.Facturacion.command.DepositBankAccountCmd;
import pe.wds.Facturacion.command.RollbackDebitBankAccountCmd;
import pe.wds.Facturacion.command.UsuarioCredencialCmd;
import pe.wds.Facturacion.event.BankAccountDebitedEvent;
import pe.wds.Facturacion.event.BankAccountDepositedEvent;
import pe.wds.Facturacion.event.UsuarioCreadoEvent;

@Saga
public class BankAccountSaga {
    
    @Autowired
    private transient CommandGateway commandGateway;

    // private String aggregateId;

    @StartSaga
    @SagaEventHandler(associationProperty = "aggregateId")
    public void onEvent(BankAccountDebitedEvent bankAccountDebitedEvent){
        System.out.println("caliiiiiiiiiiiiiiiiiiiiiiiii:::: " + commandGateway);
        System.out.println("user cccccc caliiiiiiiiiiiiiiiiiiiiiiiii:::: " + bankAccountDebitedEvent);

        String agreegateId = bankAccountDebitedEvent.getUserTransferId();
        Integer amount = bankAccountDebitedEvent.getAmount();
        SagaLifecycle.associateWith("userTransferId", agreegateId);

        String rollbackAggregateId = bankAccountDebitedEvent.getAggregateId();

        commandGateway.send(new DepositBankAccountCmd(agreegateId, amount), (commandMessage, CommandResultMessage) ->{
            if (CommandResultMessage.isExceptional()) {
                System.out.println("llego al rollback atencion cali estamos en probelmas xd");
                commandGateway.send(new RollbackDebitBankAccountCmd(rollbackAggregateId, amount));
            }else{
                System.out.println("comman sent successfully");
            }
        });
    }
    

    @SagaEventHandler(associationProperty = "aggregateId", keyName = "userTransferId")
    public void onEvent(BankAccountDepositedEvent bankAccountDepositedEvent){

        System.out.println("7778888:::: " + commandGateway);
        System.out.println("5484848484884xd caliiiiiiiiiiiiiiiiiiiiiiiii:::: " + bankAccountDepositedEvent);

    }

}
