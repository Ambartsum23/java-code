import java.util.Scanner;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class JavaTask {
    /*1. გვაქვს მთელი რიცხვების ჩამონათვალი სადაც  ერთის გარდა ყველა რიცხვი  მეორდება,
    იპოვეთ ის რიცხვი რომელიც არ მეორდება.int singleNumber(int[] nums)*/
        public int singleNumber(int[] nums) {
            int result = 0;
            for (int num : nums) {
                result ^= num;}
            return result;}
/* 2. გვაქვს 1,5,10,20 და 50 თეთრიანი მონეტები. დაწერეთ ფუნქცია, რომელსაც გადაეცემა
    თანხა (თეთრებში) და აბრუნებს მონეტების მინიმალურ რაოდენობას, რომლითაც შეგვიძლია ეს თანხა დავახურდაოთ.
    Int minSplit(Int amount)*/
    public static int minSplit(int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;}
        int[] coins = {1, 5, 10, 20, 50};
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);}
            }
        }
        return dp[amount];}

    /*3. მოცემულია მასივი, რომელიც შედგება მთელი რიცხვებისგან. დაწერეთ ფუნქცია რომელსაც გადაეცემა
ეს მასივი და აბრუნებს მინიმალურ მთელ რიცხვს, რომელიც 0-ზე მეტია და ამ მასივში არ შედის.
Int notContains(Int[] array);
*/
    public static int notContains(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : numbers) {
            set.add(num);}
        int i = 1;
        while (true) {
            if (!set.contains(i)) {
                return i;}
            i++;}
    }
  /*  4.მოცემულია ორი binary string a და b, დააბრუნეთ მათი ჯამი, როგორც binary string.
            მაგ: a = "1010" b = "1011" , მათი ჯამი იქნება "10101"*/
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;}
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;}
            result.insert(0, sum % 2);
            carry = sum / 2;}
        if (carry > 0) {
            result.insert(0, carry);}
        return result.toString();
    }
/*5. გვაქვს n სართულიანი კიბე, ერთ მოქმედებაში შეგვიძლია ავიდეთ 1 ან 2 საფეხურით.
დაწერეთ ფუნქცია რომელიც დაითვლის n სართულზე ასვლის ვარიანტების რაოდენობას.
Int countVariants(Int stearsCount);
*/
    public static int countVariants(int stairsCount) {
        if (stairsCount <= 1) {
            return 1;}
        int[] dp = new int[stairsCount + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= stairsCount; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];}
        return dp[stairsCount];}
/*6. დაწერეთ საკუთარი მონაცემთა სტრუქტურა, რომელიც საშუალებას მოგვცემს O(1) დროში წავშალოთ ელემენტი.*/
    private LinkedHashSet<Integer> elements = new LinkedHashSet<>();
    void delete(int value) {
        elements.remove(value);}


    public static void main(String[] args) {

        //1
            int[] nums = {2, 1, 3, 2, 4, 7, 5, 4, 5, 6, 7, 6, 3};
        JavaTask finder = new JavaTask();
            int singleNumber = finder.singleNumber(nums);
            System.out.println("რიცხვი რომელიც არ მეორდება " + singleNumber);

        //2
            //Scanner scanner = new Scanner(System.in);
            //System.out.println("შეიტანეთ ხელფასი თეთრებში");
            //int amount = scanner.nextInt();
            int amount = 89;
            int minCoins = minSplit(amount);
            System.out.println("მონეტების მინიმალური რაოდენობა თანხა დავახურდავლად: " + minCoins);

        //3
            int[] numbers = {1, 3, 6, 4, 2};
            int result = notContains(numbers);
            System.out.println("0-ზე მეტი უმცირესი რიცხვი რომელიც არარის მასივში " + result);

        //4
            String a = "1101010";
            String b = "101001011";
            String sum = addBinary(a, b);
            System.out.println("ორობითი რიცხვების ჯამი: " + a + " და " + b + " ტოლია " + sum);

        //5
            int stairsCount = 9;
            int variants = countVariants(stairsCount);
            System.out.println("მე-" + stairsCount +" სართულზე 1 ან 2 საფეხურით ასვლის ვარიანტების რაოდენობა: " + variants);

        //6
            JavaTask dataStructure = new JavaTask();
            dataStructure.elements.add(4);
            dataStructure.elements.add(7);
            dataStructure.elements.add(10);
            System.out.println("წავშალოთ ელემენტ 2");
            dataStructure.delete(10);
            System.out.println("ელემენტები წაშლის მერე: " + dataStructure.elements);
        }
    }