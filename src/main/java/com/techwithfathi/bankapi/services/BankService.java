package com.techwithfathi.bankapi.services;

import com.techwithfathi.bankapi.dto.user.AddMoneyRequestDto;
import com.techwithfathi.bankapi.dto.user.TransferMoneyRequestDto;
import com.techwithfathi.bankapi.dto.user.UserBalanceRequestDto;
import com.techwithfathi.bankapi.dto.user.UserLoanRequestDto;
import com.techwithfathi.bankapi.exceptions.ApiException;
import com.techwithfathi.bankapi.models.User;
import com.techwithfathi.bankapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankService {
    private final UserRepository userRepository;

    public BankService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public String addMoney(AddMoneyRequestDto addMoneyRequestDto) {

        Optional<User> user = userRepository.findByUsername(addMoneyRequestDto.getUsername());
        if (user.isEmpty())
            throw new ApiException("Invalid credentials");
        User currentUser = user.get();
        User bank = userRepository.findByUsername("BANK")
                .orElseThrow(() -> new ApiException("Internal server error"));
        if (addMoneyRequestDto.getAmount() <= 10)
            throw  new ApiException("You're out of money please add or take a loan");
        bank.setOwn(bank.getOwn() + 1);
        currentUser.setOwn(currentUser.getOwn() + addMoneyRequestDto.getAmount() - 1);
        userRepository.save(currentUser);
        userRepository.save(bank);
        return "Amount added successfully to the Accounts !";
    }

    @Transactional
    public String transferMoney(TransferMoneyRequestDto transferMoneyRequestDto) {
        List<User> users = userRepository.findByUsernameIn(List.of(
                transferMoneyRequestDto.getUsername(),
                transferMoneyRequestDto.getTo()
        ));
        if (users.size() != 2)
            throw new ApiException("Bad request");
        User from = users
                .stream()
                .filter(user -> user.getUsername().equals(transferMoneyRequestDto.getUsername()))
                .toList().get(0);

        User to = users
                .stream()
                .filter(user -> user.getUsername().equals(transferMoneyRequestDto.getTo()))
                .toList().get(0);
        User bank = users
                .stream()
                .filter(user -> user.getUsername().equals("BANK"))
                .toList().get(0);

        if (from.getOwn() - transferMoneyRequestDto.getAmount() <= 0)
            throw  new ApiException("You're out of money please add or take a loan");
        bank.setOwn(bank.getOwn() + 1);
        to.setOwn(to.getOwn() + transferMoneyRequestDto.getAmount() - 1);
        from.setOwn(from.getOwn() - transferMoneyRequestDto.getAmount());
        userRepository.saveAll(List.of(from, to, bank));
        return "Amount transferred successfully !";
    }

    public User getBalance(UserBalanceRequestDto userBalanceRequestDto) {
        Optional<User> user = userRepository.findByUsername(userBalanceRequestDto.getUsername());
        if (user.isEmpty())
            throw new ApiException("Invalid credentials");
        return user.get();
    }

    public String takeLoan(UserLoanRequestDto userLoanRequestDto) {
        Optional<User> user = userRepository.findByUsername(userLoanRequestDto.getUsername());
        if (user.isEmpty())
            throw new ApiException("Invalid credentials");
        User currentUser = user.get();
        currentUser.setOwn(currentUser.getOwn() + userLoanRequestDto.getAmount());
        currentUser.setDebt(currentUser.getDebt() + userLoanRequestDto.getAmount());
        userRepository.save(currentUser);
        return "Loan added to your Account successfully !";
    }

    public String payLoan(UserLoanRequestDto userLoanRequestDto) {
        Optional<User> user = userRepository.findByUsername(userLoanRequestDto.getUsername());
        if (user.isEmpty())
            throw new ApiException("Invalid credentials");
        User currentUser = user.get();
        if (currentUser.getOwn() < userLoanRequestDto.getAmount())
            throw new ApiException("Not enough cash in your account");
        currentUser.setOwn(currentUser.getOwn() - userLoanRequestDto.getAmount());
        currentUser.setDebt(currentUser.getDebt() - userLoanRequestDto.getAmount());
        userRepository.save(currentUser);
        return "You've successfully payed your loan";
    }
}
