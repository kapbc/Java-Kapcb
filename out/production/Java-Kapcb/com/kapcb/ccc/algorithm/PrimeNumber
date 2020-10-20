public class PrimeNumber {
    private static final int BASE_LOOP_NUMBER = 2;

    public static void main(String[] args) {
        List<Integer> primeNumber = getPrimeNumber(100, 1000);
        System.out.println(primeNumber);
    }

    private static List<Integer> getPrimeNumber(int startNumber, int endNumber) {
        List<Integer> elementList = new ArrayList<>();
        for (int i = startNumber; i < endNumber; i++) {
            boolean flag = true;
            for (int j = BASE_LOOP_NUMBER; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                elementList.add(i);
            }
        }
        return elementList;
    }
}
