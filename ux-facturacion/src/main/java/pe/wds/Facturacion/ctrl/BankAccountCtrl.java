package pe.wds.Facturacion.ctrl;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.wds.Facturacion.dto.AccountActivateDto;
import pe.wds.Facturacion.dto.AccountCreateDto;
import pe.wds.Facturacion.dto.AccountDepositDto;
import pe.wds.Facturacion.dto.AccountWithdrawDto;
import pe.wds.Facturacion.dto.DebitBankAccountDto;
import pe.wds.Facturacion.service.AccountService;

@RestController
@RequestMapping(value = "/account")
public class BankAccountCtrl {
    
    private final AccountService accountService;

    public BankAccountCtrl(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping
    public String get(){
        return "it Works!";
    }

    @PostMapping
    public CompletableFuture<String> createAccount(@RequestBody AccountCreateDto dto){
        return this.accountService.CreateAccount(dto);
    }

    @PutMapping("/{accountId}")
    public CompletableFuture<String> activateAccount(@PathVariable("accountId") String accountId){
        return this.accountService.ActivateAccount(new AccountActivateDto(accountId));
    }

    @PostMapping("/deposito")
    public AccountDepositDto depositAccount(@RequestBody AccountDepositDto dto){
        this.accountService.DepositAccount(dto);
        return dto;
    }

    @PostMapping("/retiro")
    public CompletableFuture<String> withdrawAccount(@RequestBody AccountWithdrawDto dto){
        return this.accountService.WithdrawAccount(dto);
    }

    @GetMapping("/{accountId}/events")
    public List<Object> listEvents(@PathVariable("accountId") String accountId){
        System.err.println("AccounID xxxxxxxxxxxxxxx : "+accountId);
        return this.accountService.ListEvents(accountId);
    }


    // ---------------------
    @PostMapping("/debito")
    public CompletableFuture<String> DebitAccount(@RequestBody DebitBankAccountDto dto){
        return this.accountService.DebitAccount(dto);
    }
    
}
