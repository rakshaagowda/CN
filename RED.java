package CN_LAB;
import java.util.*;

class RandomEarlyDetection {

    double minThreshold;
    double maxThreshold;
    double maxP;
    int queueSize;
    int currentQ = 0;

    public RandomEarlyDetection(double minThreshold,
                                double maxThreshold,
                                double maxP,
                                int queueSize) {
        this.minThreshold = minThreshold;
        this.maxThreshold = maxThreshold;
        this.maxP = maxP;
        this.queueSize = queueSize;
    }

    public boolean enqueue() {

        if (currentQ >= queueSize) {
            System.out.println("Queue Full → Packet Dropped");
            return false;
        }

        double dropProb = calculateDropProbability();

        if (dropProb > 0 && shouldDrop(dropProb)) {
            System.out.println("Packet Dropped (RED)");
            return false;
        }

        currentQ++;
        System.out.println("Packet Enqueued | Queue size: " + currentQ);
        return true;
    }

    double calculateDropProbability() {

        if (currentQ < minThreshold)
            return 0.0;

        if (currentQ >= maxThreshold)
            return 1.0;

        return maxP * (currentQ - minThreshold)
                     / (maxThreshold - minThreshold);
    }

    boolean shouldDrop(double prob) {
        return Math.random() < prob;
    }
}

public class RED {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter min threshold: ");
        double min = sc.nextDouble();

        System.out.print("Enter max threshold: ");
        double max = sc.nextDouble();

        System.out.print("Enter max drop probability (0-1): ");
        double prob = sc.nextDouble();

        System.out.print("Enter queue size: ");
        int size = sc.nextInt();

        System.out.print("Enter number of packets: ");
        int n = sc.nextInt();

        RandomEarlyDetection red =
                new RandomEarlyDetection(min, max, prob, size);

        for (int i = 0; i < n; i++) {
            red.enqueue();
        }

        sc.close();
    }
}
