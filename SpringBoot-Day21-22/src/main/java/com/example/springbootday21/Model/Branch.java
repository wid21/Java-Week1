package com.example.springbootday21.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name ;
    private String area;

    @ManyToOne
    @JoinColumn(name="merchant_id" ,referencedColumnName = "id")//merchant coulmn
    @JsonIgnore
    private Merchant merchant;

}
