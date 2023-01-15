package service;

import domain.Hand;

public interface DrawService {

    Hand getWinner(Hand firstPlayer, Hand secondPlayer);
}
