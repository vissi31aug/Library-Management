#Library class
class Library:
    #constructor
    def __init__(self, booksList):
        self.books = booksList

    #book available currently
    def displayAvailableBooks(self):
        print("Available books: ")
        for book in self.books: 
            print(" *" + book)

    #borrow book
    def borrowBook(self, bookName):
        if bookName in self.books:
            print(f"You have been issued {bookName}. Happy Learning!!")
            self.books.remove(bookName)
            return True
        else:
            print("Sorry!, This book is not available right now. Please wait until the book is available or borrow another book!!")
            return False

     #return book
    def returnBook(self, bookName):
        self.books.append(bookName)
        print("Thanks for returning this book! Hope you enjoyed reading it. Have a great day ahead!")



#student class
class Student: 

    #book request
    def requestBook(self):
        self.book = input("Enter the name of the book you want to borrow: ")
        return self.book
        
    # return book
    def returnBook(self):
        self.book = input("Enter the name of the book you want to return: ")
        return self.book
         

if __name__ == "__main__":
    cusatLibrary = Library(["Java", "C++", "Python","Nodejs"])
    student = Student()

    while(True):
        welcomeMsg = print("\n ====== Welcome to CUSAT Library ======")
        print("Please choose an option:")


    #dictionaries......to show list of select option

        my_dict={
        "1.": "List all the books",
        "2.": "Request a book",
        "3.": "Return a book",
        "4.": "Exit the Library"
        }
        for i in my_dict:
            print(i,my_dict[i])




        a = int(input("Enter a choice: "))
        
        if a == 1:
            cusatLibrary.displayAvailableBooks()
        elif a == 2:
            cusatLibrary.borrowBook(student.requestBook())
        elif a == 3:
            cusatLibrary.returnBook(student.returnBook())
        elif a == 4:
            print("Thanks for choosing CUSAT Library. Have a great day ahead!!")
            exit()
        else:
            print("Opps!!..Invalid Choice!")
