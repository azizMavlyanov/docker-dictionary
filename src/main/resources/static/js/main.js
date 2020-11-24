document.addEventListener('DOMContentLoaded', () => {
    const searchInput = document.getElementById('search_input');
    const search = document.getElementById('search');
    const wordTitle = document.getElementById('word_title');
    const wordDescription = document.getElementById('word_description');
    const wordNotFound = document.getElementById("word_not_found");
    const wordBlock = document.getElementById("word_block");
    const wordBtn = document.getElementById("word_btn");
    wordBlock.style.display = "none";

    search.addEventListener('click', async (e) => {
        e.preventDefault();

        wordBlock.style.display = "block";
        wordNotFound.style.display = "none";

        const searchInputValue = searchInput.value;
        const responseFromDB = await fetch(`/api/v1/words/${searchInputValue}/`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });
        const wordFromDB = await responseFromDB.json();

        if (responseFromDB.status === 200 && wordFromDB.name && wordFromDB.description) {
            wordBlock.style.display = "block";
            wordTitle.innerText = wordFromDB.name;
            wordDescription.innerText = wordFromDB.description;
        } else {
            const responseFromAPI = await fetch(`http://localhost:8082/${searchInputValue}`);
            const wordFromAPI = await responseFromAPI.text();

            if (responseFromAPI.status === 200 && wordFromAPI) {
                wordTitle.innerText = searchInputValue;
                wordDescription.innerText = wordFromAPI;
            } else {
                wordBlock.style.display = "none";
                wordNotFound.style.display = "block";
                const wordWarningMain = document.getElementById("word_warning");
                wordWarningMain.classList.remove("alert");
                wordWarningMain.classList.remove("alert-danger");
                wordWarningMain.classList.remove("alert-success");
                document.getElementById("word_warning").innerText = "";
                document.getElementById("word_input").value = "";
                document.getElementById("word_desc").value = "";
            }
        }

    });

    wordBtn.addEventListener("click", async (e) => {
        e.preventDefault();

        console.log("hi");

        const wordWarning = document.getElementById("word_warning");
        const wordInput = document.getElementById("word_input");
        const wordDesc = document.getElementById("word_desc");
        const wordInputValue = document.getElementById("word_input").value;
        const wordDescValue = document.getElementById("word_desc").value;

        if (wordInputValue && wordDescValue) {
            const responseFromDB = await fetch(`/api/v1/words`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({name: wordInputValue, description: wordDescValue})
            });

            if (responseFromDB.status === 200) {
                wordWarning.innerText = "Успешно добавленно!";
                wordWarning.setAttribute("class", "alert alert-success");
                wordWarning.setAttribute("role", "alert");
            }
        } else {
            wordWarning.innerText = "Введите валидные данные!";
            wordWarning.setAttribute("class", "alert alert-danger");
            wordWarning.setAttribute("role", "alert");
        }
    });
});