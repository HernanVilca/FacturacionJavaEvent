package pe.wds.Facturacion.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import pe.wds.Facturacion.command.ActivateBankAccountCmd;
import pe.wds.Facturacion.command.CreateBankAccountCmd;
import pe.wds.Facturacion.command.DepositBankAccountCmd;
import pe.wds.Facturacion.command.WithdrawBankAccountCmd;
import pe.wds.Facturacion.dto.AccountActivateDto;
import pe.wds.Facturacion.dto.AccountCreateDto;
import pe.wds.Facturacion.dto.AccountDepositDto;
import pe.wds.Facturacion.dto.AccountWithdrawDto;

@Service
public class AccountServiceImpl implements AccountService{

    private final CommandGateway commandGateway;

    private final EventStore eventStore;


    public AccountServiceImpl(CommandGateway commandGateway, EventStore eventStore){
        this.commandGateway = commandGateway;
        this.eventStore = eventStore;
    }

    @Override
    public CompletableFuture<String> CreateAccount(AccountCreateDto accountCreateDto) {
        System.err.println("SSS");
        return commandGateway.send(new CreateBankAccountCmd(UUID.randomUUID().toString(),UUID.randomUUID().toString()));
    }

    @Override
    public CompletableFuture<String> ActivateAccount(AccountActivateDto accountActivateDto) {
        return commandGateway.send(new ActivateBankAccountCmd(accountActivateDto.getId()));
    }

    @Override
    public CompletableFuture<String> DepositAccount(AccountDepositDto accountDepositDto) {
        return commandGateway.send(new DepositBankAccountCmd(accountDepositDto.getId(), accountDepositDto.getAmount()));
    }

    @Override
    public CompletableFuture<String> WithdrawAccount(AccountWithdrawDto accountWithdrawDto) {
        return commandGateway.send(new WithdrawBankAccountCmd(accountWithdrawDto.getId(), accountWithdrawDto.getAmount()));
    }
    
    @Override
    public List<Object> ListEvents(String accountId){
        System.err.println("Service Impl : "+accountId);
        return this.eventStore.readEvents(accountId).asStream().map(s -> s.getPayload()).collect(Collectors.toList());
    }

    
}
