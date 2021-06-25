package in.siva.convertor;

import in.siva.dto.MatchDetailsDTO;

import in.siva.model.MatchDetail;

public class MatchDetailConvertor {

	private MatchDetailConvertor() {

	}

	public static MatchDetail toMatchDetail(MatchDetailsDTO dto) {
		MatchDetail matchDetail = new MatchDetail();
		matchDetail.setStadiumName(dto.getStadiumName());
		matchDetail.setMatchDate(dto.getMatchDate());
		matchDetail.setTeamOne(dto.getTeam1());
		matchDetail.setTeamTwo(dto.getTeam2());
		matchDetail.setAvailableSeats(dto.getAvailableSeats());
		matchDetail.setTotalSeats(dto.getTotalSeats());
		matchDetail.setUpperSeatPrice(dto.getUpperSeatPrice());
		matchDetail.setLowerSeatPrice(dto.getLowerSeatPrice());
		matchDetail.setImage(dto.getImage());
		matchDetail.setMatchTime(dto.getMatchTime());
		return matchDetail;
	}
	
	
	public static MatchDetailsDTO toMatchDetailDTO(MatchDetail detail) {
		MatchDetailsDTO matchDetail =new MatchDetailsDTO();
		matchDetail.setStadiumName(detail.getStadiumName());
		matchDetail.setMatchDate(detail.getMatchDate());
		matchDetail.setTeam1(detail.getTeamOne());
		matchDetail.setTeam2(detail.getTeamTwo());
		matchDetail.setAvailableSeats(detail.getAvailableSeats());
		matchDetail.setTotalSeats(detail.getTotalSeats());
		matchDetail.setUpperSeatPrice(detail.getUpperSeatPrice());
		matchDetail.setLowerSeatPrice(detail.getLowerSeatPrice());
		matchDetail.setImage(detail.getImage());
		matchDetail.setMatchTime(detail.getMatchTime());
		matchDetail.setBookable(detail.getMatchDate());
		return matchDetail;
		
		
	}
}
