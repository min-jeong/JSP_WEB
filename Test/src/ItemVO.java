
public class ItemVO {
	
	private String name;
	private boolean isCategory;
	private int depth;
	private ItemList itemList; // 하나의 아이템이 다른 서버 아이템을 가진다.
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isCategory() {
		return isCategory;
	}
	public void setCategory(boolean isCategory) {
		this.isCategory = isCategory;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public ItemList getItemList() {
		return itemList;
	}
	public void setItemList(ItemList itemList) {
		this.itemList = itemList;
	}
	
	
}
