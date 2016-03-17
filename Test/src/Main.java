import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		ItemVO youtube = new ItemVO();
		youtube.setName("유튜브");
		youtube.setDepth(0);
		youtube.setCategory(true);
		
		ItemList subCategory1 = new ItemList();
		List<ItemVO> items = new ArrayList<ItemVO>();
		
		ItemVO game = new ItemVO();
		game.setName("게임");
		game.setDepth(1);
		game.setCategory(true);
		items.add(game);
		
		ItemVO music = new ItemVO();
		music.setName("음악");
		music.setDepth(1);
		music.setCategory(true);
		items.add(music);
		
		subCategory1.setItems(items);
		
		youtube.setItemList(subCategory1);
		ItemList gameCategory = new ItemList();
		List<ItemVO> gameItem = new ArrayList<ItemVO>();
		
		ItemVO liveAnnounce = new ItemVO();
		liveAnnounce.setName("실황");
		liveAnnounce.setDepth(2);
		liveAnnounce.setCategory(true);
		gameItem.add(liveAnnounce);
		
		ItemVO trailer = new ItemVO();
		trailer.setName("트레일러");
		trailer.setDepth(2);
		trailer.setCategory(true);
		gameItem.add(trailer);
		
		gameCategory.setItems(gameItem);
		game.setItemList(gameCategory);
		
		ItemList liveAnnouncerList = new ItemList();
		List<ItemVO> liveAnnList = new ArrayList<ItemVO>();
		ItemVO daedo = new ItemVO();
		daedo.setName("대도서관");
		daedo.setDepth(3);
		daedo.setCategory(false);
		liveAnnList.add(daedo);
		
		ItemVO djl = new ItemVO();
		djl.setName("대정령");
		djl.setDepth(3);
		djl.setCategory(false);
		liveAnnList.add(djl);
		liveAnnouncerList.setItems(liveAnnList);
		liveAnnounce.setItemList(liveAnnouncerList);
		
		ItemList trailerItemList = new ItemList();
		List<ItemVO> trailerList = new ArrayList<ItemVO>();
		ItemVO e3 = new ItemVO();
		e3.setName("E3");
		e3.setDepth(3);
		e3.setCategory(false);
		trailerList.add(e3);
		
		ItemVO production = new ItemVO();
		production.setName("제작사");
		production.setDepth(3);
		production.setCategory(false);
		trailerList.add(production);
		
		trailerItemList.setItems(trailerList);
		trailer.setItemList(trailerItemList);
		
		printTree(youtube);
		
	}
	private static void printTree(ItemVO item){
		for (int i = 0; i < item.getDepth(); i++ ) {
			System.out.print("\t");
		}
		System.out.println(item.getName());
		
		if( item.isCategory() ) {
			if ( item.getItemList() != null ) {
				List<ItemVO> items = item.getItemList().getItems();
				for( ItemVO itemVO : items ) {
					printTree(itemVO);
				}
			}
		}
	}
}
