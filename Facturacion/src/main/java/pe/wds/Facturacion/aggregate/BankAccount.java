package pe.wds.Facturacion.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import lombok.Getter;
import pe.wds.Facturacion.command.ActivateBankAccountCmd;
import pe.wds.Facturacion.command.CreateBankAccountCmd;
import pe.wds.Facturacion.command.DebitBankAccountCmd;
import pe.wds.Facturacion.command.DepositBankAccountCmd;
import pe.wds.Facturacion.command.RollbackDebitBankAccountCmd;
import pe.wds.Facturacion.command.WithdrawBankAccountCmd;
import pe.wds.Facturacion.event.BankAccountActivatedEvent;
import pe.wds.Facturacion.event.BankAccountCreatedEvent;
import pe.wds.Facturacion.event.BankAccountDebitedEvent;
import pe.wds.Facturacion.event.BankAccountDepositedEvent;
import pe.wds.Facturacion.event.BankAccountRollbackedDebitEvent;
import pe.wds.Facturacion.event.BankAccountWithdrawedEvent;

@Aggregate
@Getter
public class BankAccount {
    @AggregateIdentifier
    private String id;
    private String userId;
    private Integer amount;
    private String status;

    public BankAccount() {
    }

    @CommandHandler
    public BankAccount(CreateBankAccountCmd cmd){
        AggregateLifecycle.apply(BankAccountCreatedEvent.builder()
        .aggregateId(cmd.getAggregateId())
        .userId(cmd.getUserId())
        .build());
    }

    @EventSourcingHandler
    public void onEvent(BankAccountCreatedEvent evt){
        System.err.println("BankAccountCreatedEvent" + evt);
        id = evt.getAggregateId();
        userId = evt.getUserId();
        amount = 0;
        status = "CREATED";
    }

    @CommandHandler
    public void handle(ActivateBankAccountCmd cmd){
        if (this.status.equals("ACTIVE")){
            throw new RuntimeException("REDUNDANT_DATA - ALREADY_ACTIVE");
        }
        AggregateLifecycle.apply(BankAccountActivatedEvent.builder()
        .aggregateId(cmd.getAggregateId())
        .build());
    }

    @EventSourcingHandler
    public void onEvent(BankAccountActivatedEvent evt){
        System.err.println("BankAccountActivatedEvent" + evt);
        //? id = evt.getAggregateId();
        status = "ACTIVE";
    }

    @CommandHandler
    public void handle(DepositBankAccountCmd cmd){
        if (!this.status.equals("ACTIVE")){
            throw new RuntimeException("ILLEGAL_STATE");
        } 
        AggregateLifecycle.apply(BankAccountDepositedEvent.builder()
        .aggregateId(cmd.getAggregateId())
        .amount(cmd.getAmount())
        .build());
    }

    @EventSourcingHandler
    public void onEvent(BankAccountDepositedEvent evt){
        System.err.println("BankAccountDepositedEvent" + evt);
        amount += evt.getAmount();
    }

    @CommandHandler
    public void handle(WithdrawBankAccountCmd cmd){
        if (!this.status.equals("ACTIVE")){
            throw new RuntimeException("ILLEGAL_STATE");
        }
        if (this.amount < cmd.getAmount()){
            throw new RuntimeException("INSUFFICIENT_FUNDS");
        }
        AggregateLifecycle.apply(BankAccountWithdrawedEvent.builder()
        .aggregateId(cmd.getAggregateId())
        .amount(cmd.getAmount())
        .build());
    }

    @EventSourcingHandler
    public void onEvent(BankAccountWithdrawedEvent evt){
        System.err.println("BankAccountWithdrawedEvent" + evt);
        amount -= evt.getAmount();
    }



    @CommandHandler
    public void handle(DebitBankAccountCmd cmd){
        if (!this.status.equals("ACTIVE")){
            throw new RuntimeException("ILLEGAL_STATE");
        }
        if (cmd.getAmount() > 500) {
            throw new RuntimeException("EXCEEDED_AMOUNT");
        }
        if(this.amount < cmd.getAmount()){
            throw new RuntimeException("INSUFFICIENT_FUNDS");
        }

        AggregateLifecycle.apply(BankAccountDebitedEvent.builder()
        .aggregateId(cmd.getAggregateId())
        .amount(cmd.getAmount())
        .userTransferId(cmd.getUserTransferId())
        .build());
    }


    @EventSourcingHandler
    public void onEvent(BankAccountDebitedEvent evt){
        System.err.println("BankAccountDebitedEvent" + evt);
        amount -= evt.getAmount();
    }


    @CommandHandler
    public void handle(RollbackDebitBankAccountCmd cmd){
        if (!this.status.equals("ACTIVE")){
            throw new RuntimeException("ILLEGAL_STATE");
        }
        AggregateLifecycle.apply(BankAccountRollbackedDebitEvent.builder()
        .aggregateId(cmd.getAggregateId())
        .amount(cmd.getAmount())
        .build());
    }

    @EventSourcingHandler
    public void onEvent(BankAccountRollbackedDebitEvent evt){
        System.err.println("BankAccountRollbackedDebitEvent" + evt);
        amount += evt.getAmount();
    }
    
}
