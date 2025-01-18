package assignment01;

// Complete the code for the constructor of TVRemote and the method setChannel in TVRemote
// It is really helpful to notice that the methods up() and down() in TV prevent 
// the TV channel from going above its maximum or below 2.


public class TVRemoteObjectAdapter implements TVRemote {
    private TV tv;
    // the remote has to keep its own copy of the TV's channel
    private int tvChannel = 2;

    public TVRemoteObjectAdapter(TV tvIn) {
        tv = tvIn;
        // put a loop in to make sure the TV is at channel 2
        // by calling the down() method the maximum number of times
        // (use tv.MAX_CHANNELS)
        for (int i = 0; i < tv.MAX_CHANNELS - 2; i++)
            tv.down();
    }

    // 4 other methods defined in the interface

    public void setChannel(int newChannel) {
        // NOTE if parameter is out of limits, the loops will be infinite
        newChannel = Math.min(newChannel, tv.MAX_CHANNELS);
        newChannel = Math.max(newChannel, 2);
        // write loops to move the tv to the correct channel.
        // update tvChannel to be newChannel
        while (tvChannel < newChannel) {
            tv.up();
            tvChannel++;
        }
        while (tvChannel > newChannel) {
            tv.down();
            tvChannel--;
        }
    }

    public void showChannel() {
        System.out.print("Remote Channel is " + tvChannel + ". ");
    }

	@Override
	public void on() {
		// TODO Auto-generated method stub
		tv.on();
		
		
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		tv.off();
		
		
	}

	@Override
	public void channelUp() {
		// TODO Auto-generated method stub
		tv.up();
		tvChannel = Math.min(tv.MAX_CHANNELS, tvChannel + 1);
		
	}

	@Override
	public void channelDown() {
		// TODO Auto-generated method stub
		tv.down();
		tvChannel = Math.max(2, tvChannel -1);
		
	}
}

