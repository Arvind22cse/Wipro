public class cmd_line_arg2 {
    public static void main(String[] args) {
        if(args.length!=1) {
            System.out.println("Usage: java cmd_line_arg2 <EmpID>");
            return;
        }
       String a=args[0];
       System.out.println("Welcome " + a);

    }
}
