package net.gazeplay.games.ninja;

import net.gazeplay.GameContext;
import net.gazeplay.GameLifeCycle;
import net.gazeplay.commons.utils.Portrait;
import net.gazeplay.commons.utils.stats.Stats;

/**
 * Created by schwab on 26/12/2016.
 */
public class Ninja implements GameLifeCycle {

    private final GameContext gameContext;

    private final Stats stats;

    private Target portrait;

    public Ninja(GameContext gameContext, Stats stats) {
        super();
        this.gameContext = gameContext;
        this.stats = stats;
    }

    @Override
    public void launch() {
        portrait = new Target(gameContext, gameContext.getRandomPositionGenerator(), stats,
                Portrait.createImageLibrary());

        gameContext.getChildren().add(portrait);
    }

    @Override
    public void dispose() {
        gameContext.clear();
        portrait.currentTranslation.stop();
        portrait = null;
    }
}
