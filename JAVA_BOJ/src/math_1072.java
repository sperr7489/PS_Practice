import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class math_1072 {
    static long max = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        double gameCount = Integer.parseInt(str[0]);
        double winCount =  Integer.parseInt(str[1]);
        long winPercent = (long)(winCount*100/gameCount);
        long tempResult = 0;
        if(gameCount == winCount || winPercent >=99){
            System.out.println("-1");
        }
        else{
            tempResult = calNewWinVal(gameCount,winCount,winPercent);// tempResult에서 하나씩 줄여보면서 확인을 해야한다.
            System.out.println(tempResult);
        }
    }
    public static long calNewWinVal(double gameCount, double winCount, double winPercent  ){
        long start = 1;
        long end = max;
        long newWinPercent = 0;
        long type = 0;
        long mid = 0;

        while(start<=end){
            mid = (start+end)/2;
            newWinPercent = (long)((winCount+mid)*100/( gameCount+mid));
            type = (long)(newWinPercent-winPercent); // type는 반드시 정수라는 것!
            if(type == 0 ){
                //새로운 통계값과의 차이가 1보다 크다면 더 줄일 수 있다는 것.
                //1이랑 같아도 계속해서 최솟 값을 찾아야 하기 때문에 이분탐색을 진행하는 것이다.
                start = mid+1;
            } else {
                end = mid-1;
            }
//                if(start == mid && type ==1){
//                    break;
//                };
        }
        return start;
    }
}
