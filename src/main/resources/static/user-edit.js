let formEdit = document.forms["formEditUser"];
userEdit();

async function editModalData(id) {
    const modal = new bootstrap.Modal(document.querySelector('#editModal'));
    await userModal(formEdit, modal, id);
}

function userEdit() {
    formEdit.addEventListener("submit", ev => {
        ev.preventDefault();
        let editUserRoles = [];
        for (let i = 0; i < formEdit.roles.options.length; i++) {
            if (formEdit.roles.options[i].selected) editUserRoles.push({
                // id: formEdit.roles.value,
                name: "ROLE_" + formEdit.roles.options[i].text
            });
        }
        fetch("http://localhost:8080/api/" + formEdit.id.value, {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id: formEdit.id.value,
                name: formEdit.name.value,
                email: formEdit.email.value,
                password: formEdit.password.value,
                roles: editUserRoles
            })
        }).then(() => {
            $('#editFormCloseButton').click();
            usersTable();
        });
    });
}