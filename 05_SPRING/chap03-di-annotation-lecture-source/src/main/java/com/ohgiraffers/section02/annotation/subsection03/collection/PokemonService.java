package com.ohgiraffers.section02.annotation.subsection03.collection;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceCollection")
public class PokemonService {

    /* 설명. 같은 타입의 bean이 2개 이상일 경우 List or Map 형태의 컬렉션 형태로 주입 받을 수 있다. */
    
    /* 설명. 1. 같은 타입의 bean을 List 형태로 주입 받음 */
//    컬렉션이 고정이라 큰 의미는 없음
//    private final List<Pokemon> pokemonList;
//
//    @Autowired
//    public PokemonService(List<Pokemon> pokemonList) {
//        this.pokemonList = pokemonList;
//    }
//
//    public void pokemonAttack() {
//        pokemonList.forEach(pokemon -> pokemon.attack());
//    }

    /* 설명. 2. 같은 타입의 bean들을 map 형태로도 주입 받을 수 있다. */
    private Map<String, Pokemon> pokemonMap;

    public PokemonService(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
    }

    /* 설명. key 값은 bean의 이름은 넘어온 */
    public void pokemonAttack() {
        pokemonMap.forEach((k, v) -> {
            System.out.println("key: " + k);
            System.out.println("value: " + v);
            v.attack();
            System.out.println();
        });
    }
}
