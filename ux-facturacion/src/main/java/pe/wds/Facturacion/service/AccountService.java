package pe.wds.Facturacion.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import pe.wds.Facturacion.dto.AccountActivateDto;
import pe.wds.Facturacion.dto.AccountCreateDto;
import pe.wds.Facturacion.dto.AccountDepositDto;
import pe.wds.Facturacion.dto.AccountWithdrawDto;

public interface AccountService {
    public CompletableFuture<String> CreateAccount(AccountCreateDto accountCreateDto);
    public CompletableFuture<String> ActivateAccount(AccountActivateDto accountActivateDto);
    public CompletableFuture<String> DepositAccount(AccountDepositDto accountDepositDto);
    public CompletableFuture<String> WithdrawAccount(AccountWithdrawDto accountWithdrawDto);
    public List<Object> ListEvents(String accountId);

}
