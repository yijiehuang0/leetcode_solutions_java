
class Input {
    String o, t, thr;
    public Input(String one, String two, String three) {
        o = one;
        t = two;
        thr = three;
    }

    @Override
    public int hashCode() {
        return  o.hashCode() + t.hashCode() + thr.hashCode();
    }
}
public class BlendInterview {



    public static void main(String[] args) {
        Input in = new Input("one", "two", "three");
        Input in2 = new Input("one", "two", "three");
        System.out.println(in.hashCode());
        System.out.println(in2.hashCode());

    }
}
