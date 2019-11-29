package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {
    private QuestionAChoixMultiple questionAChoixMultiple;
    private ScoreCalculateur monScore;

    @Before
    public void testsetUp() throws Exception {
        /* given : un objet de type QuestionAChoixMultiple */
        questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)));
        monScore = new ScoreCalculateur();
    }

    @Test
    public void testcalculeScore() {
        // when un étudiant fourni l'indice correspondant à deux des trois bonnes réponses
        List<Integer> repEtudiant = new ArrayList<Integer>(Arrays.asList(2,3));
        // and : on demande le calcul du score
        Float resScore =monScore.calculeScore(repEtudiant, questionAChoixMultiple);
        //then : le score obtenu est 66.66
        assertEquals(new Float(2*100/3f),resScore, 0.01f);
        // when un étudiant fourni l'indice correspondant aux trois bonnes réponses
        List<Integer> repEtudiant2 = new ArrayList<Integer>(Arrays.asList(2,3,5));
        // and : on demande le calcul du score
        Float resScore2 =monScore.calculeScore(repEtudiant2, questionAChoixMultiple);
        //then : le score obtenu est 100
        assertEquals(new Float(100f),resScore2, 0.01f);
        // when un étudiant fourni l'indice correspondant aux mauvaises réponses
        List<Integer> repEtudiant3 = new ArrayList<Integer>(Arrays.asList(1,4));
        // and : on demande le calcul du score
        Float resScore3 =monScore.calculeScore(repEtudiant3, questionAChoixMultiple);
        // then le score obtenu est 0
        assertEquals(new Float(0f),resScore3);
    }
}