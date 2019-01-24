class Solution {
    private double radius;
    private double x_center;
    private double y_center;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double angle = Math.random() * 360;
        double r = radius * Math.sqrt(Math.random());
        return new double[]{x_center + r * Math.cos(angle), y_center + r * Math.sin(angle)};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */