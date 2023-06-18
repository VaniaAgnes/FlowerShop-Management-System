public class utility {

    public static class Table {
        private int columnSize;
        private String columns[];
        private int size[];

        public Table(int columnSize, String columns[], int size[]) {
            this.columnSize = columnSize;
            this.columns = columns;
            this.size = size;
        }
        // print the separator of the table
        private void printDivider() {
            for (int i = 0; i < this.columnSize; i++) {
                System.out.print("+");
                for (int j = 0; j < this.size[i]; j++) {
                    System.out.printf("-");
                }
            }
            System.out.println("+");
        }
        // print the header of the table
        public void printTop() {
            this.printDivider();
            System.out.print("| ");
            for (int i = 0; i < this.columnSize; i++) {
                System.out.printf(
                        String.format("%%-%ds | ", this.size[i] - 2),
                        this.columns[i]);
            }
            System.out.println();
            this.printDivider();
        }
        // print the rows of the table
        public void printRows(String rows[]) {
            System.out.print("| ");
            for (int i = 0; i < this.columnSize; i++) {
                System.out.printf(
                        String.format("%%-%ds | ", this.size[i] - 2),
                        rows[i]);
            }

            System.out.println();
            this.printDivider();
        }
    }

}
