public static class Room {
        private int index;
        private int count = 0;
        private String name;
        private String description;
        private ArrayList<String> items;
        private ArrayList<String> commands;
	private ArrayList<String> foods;
	private ArrayList<String> colors;
	private ArrayList<String> subjects;

        public int getIndex() {
            return this.index;
        }

        public void setIndex(int aIndex) {
            this.index = aIndex;
        }

        public int getCount() {
            return this.count;
        }

        public void setCount(int aCount) {
            this.count = aCount;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String aName) {
            this.name = aName;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String aDescription) {
            this.description = aDescription;
        }

        public ArrayList<String> getItems() {
            return this.items;
        }

        public void setItems(ArrayList<String> aItems) {
            this.items = aItems;
        }

        public ArrayList<String> getCommands() {
            return this.commands;
        }

        public void setCommands(ArrayList<String> aCommands) {
            this.commands = aCommands;
        }

        void printItems(ArrayList<String> roomItems) {
            if (roomItems.size() > 0) {
                System.out.print("You see a ");
                if (roomItems.size() == 1) {
                    System.out.println(roomItems.get(0) + ".");
                }
                if (roomItems.size() == 2) {
                    System.out.println(roomItems.get(0) + " and a "
                            + roomItems.get(1) + ".");
                }
                if (roomItems.size() == 3) {
                    System.out.println(roomItems.get(0) + ", "
                            + roomItems.get(1) + " and a " + roomItems.get(2)
                            + ".");
                }
            }
        }

        void count() {
            this.count++;
        }
    }
