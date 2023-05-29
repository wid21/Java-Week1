package com.example.springbootday21.Repository;

import com.example.springbootday21.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryMerchant extends JpaRepository<Merchant,Integer> {

    Merchant findMerchantById(Integer id);
}
