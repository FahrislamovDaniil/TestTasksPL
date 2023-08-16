package task1;

public class Task1 {
    public static void main(String[] args) {
        int n;
        int m;
        try {
            n = Integer.parseInt(args[0]);
            m = Integer.parseInt(args[1]);

            CycleArray ca = new CycleArray(n);
            System.out.println(ca.getPath(m));
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Введите два целочисленных положительных аргумента!");
        }
    }

    private static class CycleArray {
        private int n;
        private int[] array;

        public CycleArray() {

        }

        public CycleArray(int n) {
            if (n < 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            this.n = n;
            this.array = new int[n];

            for (int i = 0; i < n; i++) {
                this.array[i] = i + 1;
            }
        }

        public int get(int i) {
            if (i > this.n - 1) {
                return this.array[i - n * (i / n)];
            } else
                return this.array[i];
        }

        public String getPath(int m) {
            if (m <= 0 || this.n == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            StringBuilder result = new StringBuilder(Integer.toString(this.array[0]));
            int endingIndex = m - 1;

            while (this.get(endingIndex) != this.array[0]) {
                result.append(this.get(endingIndex));
                endingIndex = endingIndex + m - 1;
            }

            return result.toString();
        }
    }
}