import java.io.*;
import java.util.*;

public class ZooDesign {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String costPer[] = br.readLine().split(" ");
        int costPerMeter[] = new int[costPer.length];
        for (int index = 0; index < costPer.length; index++) {
            costPerMeter[index] = Integer.parseInt(costPer[index]);
        }
        String maxArea[] = br.readLine().split(" ");
        int maximumArea[] = new int[maxArea.length];
        for (int index = 0; index < maxArea.length; index++) {
            maximumArea[index] = Integer.parseInt(maxArea[index]);
        }

        String[] herbi = br.readLine().split(" ");
        String[] carni = br.readLine().split(" ");
        String[] aqua = br.readLine().split(" ");

        int herbiv[] = new int[herbi.length];
        int carniv[] = new int[herbi.length];
        int aquav[] = new int[herbi.length];

        for (int index = 0; index < herbiv.length; index++) {
            herbiv[index] = Integer.parseInt(herbi[index]);
            carniv[index] = Integer.parseInt(carni[index]);
            aquav[index] = Integer.parseInt(aqua[index]);
        }
        int zooBuild = Integer.parseInt(br.readLine());

        if (herbiv[0] <= 0 && herbiv[0] > 20 && carniv[0] <= 0 && carniv[0] > 20 && aquav[0] <= 0 && aquav[0] > 20
                && maximumArea[0] <= 0 && maximumArea[0] > 500 && maximumArea[1] <= 0 && maximumArea[1] > 500 && maximumArea[2] <= 0 && maximumArea[2] > 500
                && zooBuild <= 0 && zooBuild > 1000
                && herbiv[1] <= 0 && herbiv[1] > 15 && carniv[1] <= 0 && carniv[1] > 15 && aquav[1] <= 0 && aquav[1] > 15
                && costPerMeter[0] <= 0 && costPerMeter[0] > 10000 && costPerMeter[1] <= 0 && costPerMeter[1] > 10000 && costPerMeter[2] <= 0 && costPerMeter[2] > 10000) {
            System.out.println("-1");
        }

        int max = 0, min = 0, mid = 0;
        if (costPerMeter[0] > costPerMeter[1] && costPerMeter[0] > costPerMeter[2]) {
            max = herbiv[0] * herbiv[1] * costPerMeter[0];
            zooBuild -= herbiv[0] * herbiv[1];
        } else if (costPerMeter[1] > costPerMeter[0] && costPerMeter[1] > costPerMeter[2]) {
            max = carniv[0] * carniv[1] * costPerMeter[1];
            zooBuild -= carniv[0] * carniv[1];
        } else if (costPerMeter[2] > carniv[1] && costPerMeter[2] > costPerMeter[0]) {
            max = aquav[0] * aquav[1] * costPerMeter[2];
            zooBuild -= aquav[0] * aquav[1];
        }
        if (costPerMeter[0] < costPerMeter[1] && costPerMeter[0] < costPerMeter[2]) {
            min = maximumArea[0] * costPerMeter[0];
            zooBuild -= maximumArea[0];
        } else if (costPerMeter[1] < costPerMeter[0] && costPerMeter[1] < costPerMeter[2]) {
            min = maximumArea[1] * costPerMeter[1];
            zooBuild -= maximumArea[1];
        } else if (costPerMeter[2] < carniv[1] && costPerMeter[2] < costPerMeter[0]) {
            min = maximumArea[2] * costPerMeter[2];
            zooBuild -= maximumArea[2];
        }

        if (costPerMeter[0] < costPerMeter[1] && costPerMeter[0] > costPerMeter[2]
                || costPerMeter[0] > costPerMeter[1] && costPerMeter[0] < costPerMeter[2]) {
            mid = costPerMeter[0] * zooBuild;
        } else if (costPerMeter[1] < costPerMeter[0] && costPerMeter[1] > costPerMeter[2]
                || costPerMeter[1] > costPerMeter[0] && costPerMeter[1] < costPerMeter[2]) {
            mid = costPerMeter[1] * zooBuild;
        } else if (costPerMeter[2] < carniv[1] && costPerMeter[2] > costPerMeter[0]
                || costPerMeter[2] > carniv[1] && costPerMeter[2] < costPerMeter[0]) {
            mid = costPerMeter[2] * zooBuild;
        }
        long result = (long) Math.floor(max + min + mid);
        System.out.println(result);
    }

}
