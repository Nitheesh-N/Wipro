class Main
{
public static void main(String args[])
{
// create boxes using the various
// constructors
ThreeDimensionShape shape1 = new ThreeDimensionShape(5, 6, 7); 
ThreeDimensionShape shape2 = new ThreeDimensionShape();
ThreeDimensionShape shape3 = new ThreeDimensionShape(8);

double volume = shape1.volume();
System.out.println("Volume of shape1 is " + volume);

double volume2 = shape2.volume();
System.out.println("Volume of shape2 is " + volume2);

double volume3 = shape3.volume();
System.out.println("Volume of shape3 is " + volume3);
}
}
class ThreeDimensionShape
 
{
double width, length, depth;

// constructor used when all dimensions are defined 
ThreeDimensionShape (double w, double l, double d)
{
     width = w;
     length = l;
     depth = d;
}

// constructor used when one dimension is defined

ThreeDimensionShape (double l)
{
   length = l;
   width = l;
   depth = l;
}

// constructor used when no dimension is specified 
ThreeDimensionShape()
{
   length = 0;
   width = 0;
   depth = 0;

}


// compute and return volume 
double volume()
{
return width * length * depth;
}
}