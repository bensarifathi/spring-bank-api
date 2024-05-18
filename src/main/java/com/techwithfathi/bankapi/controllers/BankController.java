package com.techwithfathi.bankapi.controllers;

import com.techwithfathi.bankapi.dto.user.*;
import com.techwithfathi.bankapi.models.User;
import com.techwithfathi.bankapi.services.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class BankController {
    private final BankService bankService;


    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMoney(@RequestBody AddMoneyRequestDto addMoneyRequestDto) {
        return ResponseEntity
                .ok(bankService.addMoney(addMoneyRequestDto));
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(@RequestBody TransferMoneyRequestDto transferMoneyRequestDto) {
        return ResponseEntity
                .ok(bankService.transferMoney(transferMoneyRequestDto));
    }

    @PostMapping("/balance")
    public ResponseEntity<UserBalanceResponseDto> getBalance(@RequestBody UserBalanceRequestDto userBalanceRequestDto) {
        User user = bankService.getBalance(userBalanceRequestDto);
        UserBalanceResponseDto userBalance = new UserBalanceResponseDto();
        userBalance.setUsername(user.getUsername());
        userBalance.setOwn(user.getOwn());
        userBalance.setDebt(user.getDebt());
        return ResponseEntity
                .ok(userBalance);
    }

    @PostMapping("/takeloan")
    public ResponseEntity<String> takeLoan(@RequestBody UserLoanRequestDto userLoanRequestDto) {
        return ResponseEntity.ok(bankService.takeLoan(userLoanRequestDto));
    }

    @PostMapping("/payloan")
    public ResponseEntity<String> payloan(@RequestBody UserLoanRequestDto userLoanRequestDto) {
        return ResponseEntity.ok(bankService.payLoan(userLoanRequestDto));
    }
}
