package by.vladsimonenko.fourthlab.variantB.net;

import by.vladsimonenko.fourthlab.variantB.entity.GameRoom;
import by.vladsimonenko.fourthlab.variantB.entity.Toy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;

public class ServerThread extends Thread {
    static final Logger logger = LogManager.getLogger();
    private Socket clientSocket;
    private OutputStreamWriter writer;
    private GameRoom room;


    public ServerThread(Socket socket, GameRoom room) {
        this.clientSocket = socket;
        this.room = room;
        try {
            writer = new OutputStreamWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }

    public void run() {
        List<Toy> toys = room.getToys();

        try {
            begin();
            writer.write("<table id=\"myTable\">\n");
            writer.write("<tr>\n" +
                    "    <th onclick=\"sortTable(0)\">Название</th>\n" +
                    "    <th onclick=\"sortTable(1)\">Размер</th>\n" +
                    "    <th onclick=\"sortTableNumber(2)\">Цена</th>\n" +
                    "    <th onclick=\"sortTableNumber(3)\">Возраст</th>\n" +
                    "  </tr>");
            sortTable();
            sortTableNumber();

            for (int i = 0; i < toys.size(); i++) {
                writer.write("<tr>\n" +
                        "    <td>" + toys.get(i).getTitle() + "</td>\n" +
                        "    <td>" + toys.get(i).getSize() + "</td>\n" +
                        "    <td>" + toys.get(i).getPrice() + "</td>\n" +
                        "    <td>" + toys.get(i).getAge() + "</td>\n" +
                        "  </tr>");
            }

            sortByPriceInRange();

            writer.flush();
            disconnect();

        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }

    private void disconnect() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private void sortTable() {
        try {
            writer.write("<script>\n" +
                    "function sortTable(n) {\n" +
                    "  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;\n" +
                    "  table = document.getElementById(\"myTable\");\n" +
                    "  switching = true;\n" +
                    "  dir = \"asc\"; \n" +
                    "  while (switching) {\n" +
                    "    switching = false;\n" +
                    "    rows = table.rows;\n" +
                    "    for (i = 1; i < (rows.length - 1); i++) {\n" +
                    "      shouldSwitch = false;\n" +
                    "      x = rows[i].getElementsByTagName(\"TD\")[n];\n" +
                    "      y = rows[i + 1].getElementsByTagName(\"TD\")[n];\n" +
                    "      if (dir == \"asc\") {\n" +
                    "        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {\n" +
                    "          shouldSwitch= true;\n" +
                    "          break;\n" +
                    "        }\n" +
                    "      } else if (dir == \"desc\") {\n" +
                    "        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {\n" +
                    "          shouldSwitch = true;\n" +
                    "          break;\n" +
                    "        }\n" +
                    "      }\n" +
                    "    }\n" +
                    "    if (shouldSwitch) {\n" +
                    "      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);\n" +
                    "      switching = true;\n" +
                    "      switchcount ++;      \n" +
                    "    } else {\n" +
                    "      if (switchcount == 0 && dir == \"asc\") {\n" +
                    "        dir = \"desc\";\n" +
                    "        switching = true;\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }\n" +
                    "}\n" +
                    "</script>");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private void begin() {
        try {
            writer.write(
                    "HTTP/1.0 200 OK\n" +
                            "content-type: text/html\n" +
                            "\n" +
                            "<html lang=\"ru\">\n" +
                            "<head>\n" +
                            "<meta charset=\"UTF-8\" />\n" +
                            "<style>\n" +
                            "table {\n" +
                            "  border-spacing: 0;\n" +
                            "  width: 100%;\n" +
                            "  border: 1px solid #ddd;\n" +
                            "}\n" +
                            "\n" +
                            "th, td {\n" +
                            "  text-align: left;\n" +
                            "  padding: 16px;\n" +
                            "}\n" +
                            "\n" +
                            "tr:nth-child(even) {\n" +
                            "  background-color: #f2f2f2\n" +
                            "}\n" +
                            "</style>\n" +
                            "</head>\n" +
                            "<body>"
            );
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private void sortTableNumber() {
        try {
            writer.write("<script>\n" +
                    "function sortTableNumber(n) {\n" +
                    "  var table, rows, switching, i, x, y, shouldSwitch;\n" +
                    "  table = document.getElementById(\"myTable\");\n" +
                    "  switching = true;\n" +
                    "  while (switching) {\n" +
                    "    switching = false;\n" +
                    "    rows = table.rows;\n" +
                    "    for (i = 1; i < (rows.length - 1); i++) {\n" +
                    "      shouldSwitch = false;\n" +
                    "      x = rows[i].getElementsByTagName(\"TD\")[n];\n" +
                    "      y = rows[i + 1].getElementsByTagName(\"TD\")[n];\n" +
                    "      if (Number(x.innerHTML) > Number(y.innerHTML)) {\n" +
                    "        shouldSwitch = true;\n" +
                    "        break;\n" +
                    "      }\n" +
                    "    }\n" +
                    "    if (shouldSwitch) {\n" +
                    "      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);\n" +
                    "      switching = true;\n" +
                    "    }\n" +
                    "  }\n" +
                    "}\n" +
                    "</script>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sortByPriceInRange() {
        try {
            writer.write("Цена\n" +
                    "От:" +
                    "<form>\n" +
                    "<input type=\"text1\" id = \"input1-id\">\n" +
                    "</form>\n" +
                    "До:" +
                    "<form>\n" +
                    "<input type=\"text2\" id = \"input2-id\">\n" +
                    "</form>\n" +
                    "<button type=\"submit\" id=\"submit\" onclick=\"deleteRow();\">Сортировка</button>\n");

            writer.write("<script>\n" +
                    "function deleteRow() {\n" +
                    "var table, rows, deleting, i, x, shouldDelete, minPrice, maxPrice;\n" +
                    "minPrice = document.getElementById(\"input1-id\").value;\n" +
                    "maxPrice = document.getElementById(\"input2-id\").value;\n" +
                    "table = document.getElementById(\"myTable\");\n" +
                    "deleting = true;\n" +
                    "while (deleting) {\n" +
                    "  deleting = false;\n" +
                    "  rows = table.rows;\n" +
                    "  for (i = 1; i < rows.length; i++) {\n" +
                    "     shouldDelete = false;\n" +
                    "     x = rows[i].getElementsByTagName(\"TD\")[2];\n" +
                    "     if ((Number(x.innerHTML) > Number(maxPrice)) ||(Number(x.innerHTML) < Number(minPrice)) ) {\n" +
                    "         shouldDelete = true;\n" +
                    "         break;\n" +
                    "    }\n" +
                    "   }\n" +
                    "  if (shouldDelete) {\n" +
                    "     rows[i].parentElement.removeChild(rows[i]);\n" +
                    "     deleting = true;\n" +
                    "   }\n" +
                    "  }\n" +
                    " }\n" +
                    "</script>");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
