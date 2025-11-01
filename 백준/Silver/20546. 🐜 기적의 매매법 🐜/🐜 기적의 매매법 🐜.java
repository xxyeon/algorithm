import java.io.*;
import java.util.*;

class Asset {
    int money;
    int stock;
    Asset(int money, int stock) {
        this.money = money;
        this.stock = stock;
    }
    void buy(int nowStock) {
        //현재주가:nowStock
        //현재 매수 가능한 주가수: money/nowStock
        //전량매수
        int stock = money / nowStock;
        if(money >= nowStock) {
            this.stock += stock;
            money -= nowStock * stock;
        }

    }
    void sell(int nowStock) {
        if(stock > 0) {
            money += stock * nowStock;
            stock = 0;
        }
    }
}

public class Main {
    static int[] assets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Asset bnp = new Asset(N, 0);
        Asset timing = new Asset(N, 0);
        assets = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //bnp
        for(int i=0;i<assets.length;i++) {
            if(assets[i] <= bnp.money) {
                //전량매수
                bnp.buy(assets[i]);
            }
        }

        int increasing = 0;
        int decreasing = 0;
        //timing
        for (int i = 1; i < assets.length; i++) {

            if(assets[i-1] < assets[i]) {
                //연속 증가
                increasing++;
                decreasing=0;
            } else if (assets[i - 1] > assets[i]) {
                decreasing++;
                increasing=0;
            } else {
                decreasing=0;
                increasing=0;
            }
            if(increasing >= 3) {
                //전량매도
                timing.sell(assets[i]);
            }
            else if(decreasing >= 3) {
                timing.buy(assets[i]);
            }
        }

        int finalMoney = assets[assets.length - 1];
        int a = bnp.money + bnp.stock * finalMoney;
        int b = timing.money + timing.stock * finalMoney;
        if(a > b) {
            System.out.print("BNP");
        } else if(a < b) {
            System.out.print("TIMING");
        } else {
            System.out.print("SAMESAME");
        }
        
    }


}