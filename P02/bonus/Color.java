public enum Color
{
        PURPLE(8388736), ORANGE(16753920),
        PINK(16761035), BROWN(10824234);

        private final int rgb;
        private Color(int rgb)
        {
                this.rgb = rgb;
        }
        public String toString()
        {
                return rgb;
        }

} // enum for colors
