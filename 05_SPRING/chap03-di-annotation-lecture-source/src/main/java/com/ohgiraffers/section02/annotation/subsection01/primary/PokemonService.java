package com.ohgiraffers.section02.annotation.subsection01.primary;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonServicePrimary")
public class PokemonService {

    private Pokemon pokemon;

    @Autowired // 생성자 주입은 @Autowired 생략 가능
    /* 설명. 여러 Pokemon 콩이 있을 경우 에러가 나는데 @Primary 달아주면 우선 순위 설정 가능 */
    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        this.pokemon.attack();
    }
}
