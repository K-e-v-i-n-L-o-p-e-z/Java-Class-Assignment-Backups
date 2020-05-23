//import java.awt.*;
//
//public class ImageIcon extends javax.swing.ImageIcon {
//    String identifier;
//    ImageIcon(String fileName, String identifier){
//        super(fileName);
//        this.identifier = identifier;
//    }
//    ImageIcon(Image image, String identifier){
//        super(image);
//        this.identifier = identifier;
//    }
//    @Override
//    public boolean equals(Object other){
//        ImageIcon otherImage = (ImageIcon) other;
//        if (other == null) {
//            return false;
//        }
//        return identifier.equals(otherImage.identifier);
//    }
//    public String getIdentifier(){
//        return this.identifier;
//    }
//
//}