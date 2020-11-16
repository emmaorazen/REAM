import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.JLabel;

public class MovieAppInterface extends JFrame implements ActionListener
{
	User u;
	private JButton but1;
	private JButton but2;
	private JButton but3;
	private JButton but4;
	private JButton gBut4;
	private JButton gBut5;
	private JButton gBut6;
	private JButton gBut7;
	private JButton gBut8;
	private JButton gBut9;
	private JPanel panel;
	JLabel prompt = new JLabel();
	JTextArea movies = new JTextArea();
	JTextArea info = new JTextArea();
	JTextField search = new JTextField(20);
	JLabel movie1 = new JLabel();
	JLabel movie2 = new JLabel();
	private JButton searchButton;
	private JButton sortByRating;
	private JButton aboutButton;
	JTextArea allComments = new JTextArea();
	// images
	JLabel label;
	JLabel label2;
	boolean moviePicUp = false;
	static ArrayList<Movie> movieArray = new ArrayList();
	/**
	 * constructor creates all components of a ColorFrame! 
	 */
	public MovieAppInterface(User u)
	{
		this.u = u;
		but1 = new JButton("Movies");
		but1.addActionListener(this);
		but2= new JButton("Genres");
		but2.addActionListener(this);
		but3 = new JButton("Profile");
		but3.addActionListener(this);
		but4 = new JButton("Comments");
		but4.addActionListener(this);
		gBut4 = new JButton("Fantasy");
		gBut5 = new JButton("Comedy");
		gBut6 = new JButton("Romance");
		gBut7 = new JButton("Sci-Fi");
		gBut8 = new JButton("Mystery");
		gBut9 = new JButton("Feel-Good");
		searchButton = new JButton("Search");
		sortByRating = new JButton("Sort by Rating");
		aboutButton = new JButton("About");
		gBut4.addActionListener(this);
		gBut5.addActionListener(this);
		gBut6.addActionListener(this);
		gBut7.addActionListener(this);
		gBut8.addActionListener(this);
		gBut9.addActionListener(this);
		searchButton.addActionListener(this);
		sortByRating.addActionListener(this);
		aboutButton.addActionListener(this);
		panel = new JPanel();
		
		panel.add(but1);
		panel.add(but2);
		panel.add(but3);
		panel.add(but4);

		JFrame frame = new JFrame();
		frame.add(panel);
		frame.setSize(455, 600);
		frame.setTitle("MovieApp");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		String[] actors = {"Actor Name","",""};
		movieArray.add(new Movie("The Hobbit", "Fantasy", 10, actors, new File("./TheHobbit.png")));
		String[] actors2 = {"Actor Name","",""};
		movieArray.add(new Movie("Maleficent", "Fantasy", 6, actors2, new File("./Maleficent.png")));
		String[] actors3 = {"Actor Name","",""};
		movieArray.add(new Movie("Lord of the Rings", "Fantasy", 10, actors3, new File("./LordOfTheRings.png")));
		String[] actors4 = {"Actor Name","",""};
		movieArray.add(new Movie("Harry Potter", "Fantasy", 9, actors4, new File("./HarryPotter.png")));
		String[] actors5 = {"Actor Name","",""};
		movieArray.add(new Movie("The Martian", "Sci-Fi", 9, actors5, new File("./TheMartian.png")));
		String[] actors6 = {"Actor Name","",""};
		movieArray.add(new Movie("Ender's Game", "Sci-Fi", 8, actors6, new File("./Ender'sGame.png")));
		String[] actors7 = {"Actor Name","",""};
		movieArray.add(new Movie("The Pricess Bride", "Romance", 8, actors7, new File("./ThePricessBride.png")));
		String[] actors8 = {"Actor Name","",""};
		movieArray.add(new Movie("A Goofy Movie", "Comedy", 7, actors8, new File("./AGoofyMovie.png")));
		String[] actors9 = {"Actor Name","",""};
		movieArray.add(new Movie("Megamind", "Comedy", 7, actors9, new File("./Megamind.png")));
		String[] actors10 = {"Actor Name","",""};
		movieArray.add(new Movie("Cinderella", "Romance", 6, actors10, new File("./Cinderella.png")));
		String[] actors11 = {"Actor Name","",""};
		movieArray.add(new Movie("The Hound of the Baskerville", "Mystery", 5, actors11, new File("./TheHoundOfTheBaskervilles.png")));
		String[] actors12 = {"Actor Name","",""};
		movieArray.add(new Movie("A Study in Scarlet", "Mystery", 4, actors12, new File("./AStudyInScarlet.png")));
		String[] actors13 = {"Actor Name","",""};
		movieArray.add(new Movie("Zootopia", "Feel-Good", 8, actors13, new File("./Zootopia.png")));
		String[] actors14 = {"Actor Name","",""};
		movieArray.add(new Movie("Ratatouille", "Feel-Good", 6, actors14, new File("./Ratatouille.png")));
	}

	/**
	 * gives each of the buttons an action 
	 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent event) 
	{
		User u = this.u;
		
		panel.removeAll();
		panel.add(but1);
		panel.add(but2);
		panel.add(but3);
		panel.add(but4);
		
		// ** Movie tab
		if(event.getActionCommand().equals("Movies")) {
			// Movie tab
			panel.add(prompt);
			// Search feature
			panel.add(search);
			panel.add(searchButton);
			// Sort feature
			panel.add(sortByRating);
			
			prompt.setText("This is a list of movies\n");
			
			// Movie list
			try {
				if(!moviePicUp) {
					for(int i = 0; i < movieArray.size(); i++) {
						BufferedImage image = ImageIO.read(movieArray.get(i).getImageFile());
						Image scaledImage = image.getScaledInstance(50, 75, Image.SCALE_SMOOTH);
						movieArray.get(i).movieImage = new JLabel(new ImageIcon(scaledImage));
					}
					moviePicUp = true;
				}
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i < movieArray.size(); i++) {
				movieArray.get(i).getMovieTitle().setText(movieArray.get(i).getName());
				panel.add(movieArray.get(i).getMovieTitle());
				//aboutButton = new JButton("About " + i);
				//aboutButton.addActionListener(this);
				//panel.add(aboutButton);
				panel.add(movieArray.get(i).getMovieImage());
			}
			panel.repaint();
		}
		
		if(event.getActionCommand().equals("Search")) {
			panel.add(prompt);
			// Search feature
			panel.add(search);
			panel.add(searchButton);
			// Sort feature
			panel.add(sortByRating);
			
			for(int i = 0; i < movieArray.size(); i++) {
				if(movieArray.get(i).getName().contains(search.getText())) {
					panel.add(movieArray.get(i).getMovieTitle());
					panel.add(movieArray.get(i).getMovieImage());
				}
			}
		}
		
		if(event.getActionCommand().equals("Sort by Rating")) {
			panel.add(prompt);
			// Search feature
			panel.add(search);
			panel.add(searchButton);
			// Sort feature
			panel.add(sortByRating);
			
			// sorts copy of array list
			ArrayList<Movie> movieSort = new ArrayList<>(movieArray);
			// sorts with bubble sort by rating
			for(int i = 0; i < movieSort.size() - 1; i++) {
				for(int j = 0; j < movieSort.size() - i -1; j++) {
					if(movieSort.get(j).getRate() > movieSort.get(j+1).getRate()) {
						Movie temp = movieSort.get(j);
						movieSort.set(j, movieSort.get(j+1));
						movieSort.set(j+1, temp);
					}
				}
			}
			Collections.reverse(movieSort);
			
			// displays sorted movies
			for(int i = 0; i < movieSort.size(); i++) {
				panel.add(movieSort.get(i).getMovieTitle());
				panel.add(movieSort.get(i).getMovieImage());
			}
		}
		
		// ** Genre tab
		if(event.getActionCommand().equals("Genres")) {
			panel.add(prompt);
			prompt.setText("This is a list of genres\n");
			panel.add(gBut4);
			panel.add(gBut5);
			panel.add(gBut6);
			panel.add(gBut7);
			panel.add(gBut8);
			panel.add(gBut9);
		}
		
		if(event.getActionCommand().equals("Fantasy")) {
			panel.add(prompt);
			prompt.setText("This is a list of genres\n");
			panel.add(gBut4);
			panel.add(gBut5);
			panel.add(gBut6);
			panel.add(gBut7);
			panel.add(gBut8);
			panel.add(gBut9);
			for(int i = 0; i < movieArray.size(); i++) {
				if(movieArray.get(i).getGenre().equals("Fantasy")) {
					panel.add(movieArray.get(i).getMovieTitle());
					panel.add(movieArray.get(i).getMovieImage());
				}
			}
		}
		
		if(event.getActionCommand().equals("Comedy")) {
			panel.add(prompt);
			prompt.setText("This is a list of genres\n");
			panel.add(gBut4);
			panel.add(gBut5);
			panel.add(gBut6);
			panel.add(gBut7);
			panel.add(gBut8);
			panel.add(gBut9);
			for(int i = 0; i < movieArray.size(); i++) {
				if(movieArray.get(i).getGenre().equals("Comedy")) {
					panel.add(movieArray.get(i).getMovieTitle());
					panel.add(movieArray.get(i).getMovieImage());
				}
			}
		}
		
		if(event.getActionCommand().equals("Romance")) {
			panel.add(prompt);
			prompt.setText("This is a list of genres\n");
			panel.add(gBut4);
			panel.add(gBut5);
			panel.add(gBut6);
			panel.add(gBut7);
			panel.add(gBut8);
			panel.add(gBut9);
			for(int i = 0; i < movieArray.size(); i++) {
				if(movieArray.get(i).getGenre().equals("Romance")) {
					panel.add(movieArray.get(i).getMovieTitle());
					panel.add(movieArray.get(i).getMovieImage());
				}
			}
		}
		
		if(event.getActionCommand().equals("Sci-Fi")) {
			panel.add(prompt);
			prompt.setText("This is a list of genres\n");
			panel.add(gBut4);
			panel.add(gBut5);
			panel.add(gBut6);
			panel.add(gBut7);
			panel.add(gBut8);
			panel.add(gBut9);
			for(int i = 0; i < movieArray.size(); i++) {
				if(movieArray.get(i).getGenre().equals("Sci-Fi")) {
					panel.add(movieArray.get(i).getMovieTitle());
					panel.add(movieArray.get(i).getMovieImage());
				}
			}
		}
		
		if(event.getActionCommand().equals("Mystery")) {
			panel.add(prompt);
			prompt.setText("This is a list of genres\n");
			panel.add(gBut4);
			panel.add(gBut5);
			panel.add(gBut6);
			panel.add(gBut7);
			panel.add(gBut8);
			panel.add(gBut9);
			for(int i = 0; i < movieArray.size(); i++) {
				if(movieArray.get(i).getGenre().equals("Mystery")) {
					panel.add(movieArray.get(i).getMovieTitle());
					panel.add(movieArray.get(i).getMovieImage());
				}
			}
		}
		
		if(event.getActionCommand().equals("Feel-Good")) {
			panel.add(prompt);
			prompt.setText("This is a list of genres\n");
			panel.add(gBut4);
			panel.add(gBut5);
			panel.add(gBut6);
			panel.add(gBut7);
			panel.add(gBut8);
			panel.add(gBut9);
			for(int i = 0; i < movieArray.size(); i++) {
				if(movieArray.get(i).getGenre().equals("Feel-Good")) {
					panel.add(movieArray.get(i).getMovieTitle());
					panel.add(movieArray.get(i).getMovieImage());
				}
			}
		}
		
		// ** Profile tab
		if(event.getActionCommand().equals("Profile")) {
			panel.add(prompt);
			prompt.setText("Profile Information:");
			
			Scanner obj = null;
			File users = null;

			try 
			{
				users=new File("users.txt");
				obj = new Scanner(users);
				String s = "";

				while(obj.hasNextLine()) 
				{
					s = obj.nextLine() + "\n";
				}
				int i = s.indexOf(", ");
				String start = s.substring(0,i);
				String end = s.substring(i+2,s.length());
				info.setText("Username: " + start + "\nPassword: " + end);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			finally
			{
				obj.close();
			}
			panel.add(info);
		}
		
		if(event.getActionCommand().equals("Comments")) {
			panel.add(prompt);
			prompt.setText("This is all comments for all of the movies.\n");
			
			Scanner obj = null;
			File comments = null;

			try {
				comments = new File("comments.txt");
				obj = new Scanner(comments);
				String s = "";

				while(obj.hasNextLine()) {
					s = obj.nextLine() + "\n";
				}
				
				allComments.setText(s);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			finally
			{
				obj.close();
			}
		}
		
		// refresh bug fixed
		panel.revalidate();
		panel.repaint();
	}

	/**
	 * 
	 * @param args sets the new ColorFrame visible 
	 */
	public static void main(String[] args)
	{
		User u = new User();
		MovieAppInterface color = new MovieAppInterface(u);
		color.setVisible (true);
	}
}
