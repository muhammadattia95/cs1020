/*
 * Name: Wong Kang Fei
 * Matric Number: A0138862W
 * */

import java.util.*;

public class Tournament {
	private static Participant[] participants;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		final int PARTICIPANT_COUNT = sc.nextInt();
		participants = new Participant[PARTICIPANT_COUNT];

		final int ITERATION_COUNT = sc.nextInt();

		sc.nextLine(); // consume line feed
	
		for(int i = 0; i<PARTICIPANT_COUNT; i++){
			participants[i] = new Participant(sc.next(), sc.nextInt());
			sc.nextLine(); //consume line feed
		}

		Arrays.sort(participants);

		for(int i = 0; i<ITERATION_COUNT;i++){
			for(int j=0; j<PARTICIPANT_COUNT; j++){
				Participant participant = participants[j];
				
				int x = (participant.getSeatNumber()*ITERATION_COUNT);
				int newSeatNumber =	x>=PARTICIPANT_COUNT? x%PARTICIPANT_COUNT : x;
				participant.setSeatNumber(newSeatNumber);
			}
		
			Arrays.sort(participants);

			for(int j = 0; j<PARTICIPANT_COUNT; j++){
				Participant targetParticipant = participants[j];
				Participant leftParticipant;
				Participant rightParticipant;
				if(j == 0){
					leftParticipant = participants[PARTICIPANT_COUNT-1];
					rightParticipant = participants[j+1];
				}else if( j == PARTICIPANT_COUNT-1){
					leftParticipant = participants[j-1];
					rightParticipant = participants[0];
				}else{
					leftParticipant = participants[j-1];
					rightParticipant = participants[j+1];
				}

				targetParticipant.setScore(targetParticipant.getScore() + leftParticipant.getCardNumber() + rightParticipant.getCardNumber());
			}

		}

		Participant highestScoreParticipant = null;

		for(int i=0; i<PARTICIPANT_COUNT; i++){
			if(highestScoreParticipant == null){
				highestScoreParticipant = participants[i];
			}else{
				highestScoreParticipant = participants[i].getScore() > highestScoreParticipant.getScore() ? participants[i] : highestScoreParticipant;
			}
		}

		System.out.println(highestScoreParticipant.getName() + " " + highestScoreParticipant.getScore());
	}

	private static void prettyPrint(){
		System.out.println("=====");
		for(int i=0; i<participants.length;i++){
			System.out.println(participants[i].getName()+":"+participants[i].getSeatNumber()+":"+participants[i].getScore());
		}
		System.out.println("=====");
	}
}

class Participant implements Comparable<Participant>{
	//define the appropriate attributes and constructor
	
	private String name;
	private int cardNumber;
	private int seatNumber;
	private int score;

	public Participant(String name, int cardNumber){
		this.name = name;
		this.cardNumber = cardNumber;
		this.seatNumber = cardNumber;
		this.score = 0;
	}

	public String getName(){
		return name;
	}

	public int getCardNumber(){
		return cardNumber;
	}

	public void setCardNumber(int cardNumber){
		this.cardNumber = cardNumber;
	}

	public int getSeatNumber(){
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber){
		this.seatNumber = seatNumber;
	}

	public int getScore(){
		return score;
	}

	public void setScore(int score){
		this.score = score;
	}

	public int compareTo(Participant participant){
		return this.seatNumber - participant.getSeatNumber();
	}
}

