package imran.num2word.service;

public class Segmenter implements Segment {

    public String getSegment(int startIndex, String number) {
        return number.substring(3 * startIndex, 3 * (startIndex + 1));
    }
}
