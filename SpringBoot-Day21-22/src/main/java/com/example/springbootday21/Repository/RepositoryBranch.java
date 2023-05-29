package com.example.springbootday21.Repository;

import com.example.springbootday21.Model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositoryBranch extends JpaRepository<Branch,Integer> {


    Branch findBranchById(Integer id);
}

