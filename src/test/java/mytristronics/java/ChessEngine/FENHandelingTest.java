package mytristronics.java.ChessEngine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class FENHandelingTest {


    @Test
    void bitScanForwardDbl() {
        measurePerformance(100);
    }

    void measurePerformance(int r){
        Random ran = new Random();
        for (int i = 0;i<r;i++){
            FENHandeling.bitScanForwardDbl(ran.nextLong());
        }
    }
}